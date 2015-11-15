#!/usr/bin/perl -w -l

use File::Basename;
use Cwd 'abs_path';
use strict;
use DBI;
use JSON::XS;

my $dbh = DBI->connect("dbi:mysql:dbname=mvl","richi", "thispwdisnotsafe", {RaiseError => 1},) or die $DBI::errstr;

#my $sth = $dbh->prepare("SELECT * FROM be_bucheintragungen LEFT JOIN b_buecher b ON be_bucheintragungen.be_b_buch = b.b_id");
my $sth = $dbh->prepare("SELECT * FROM b_buecher");
$sth->execute();

my $maps = [];
my $time = localtime(time);
push $maps, { timestamp => $time };
my $row;
while ($row = $sth->fetchrow_arrayref())
{
	my $pages = [];
	my $sth2 = $dbh->prepare("SELECT * FROM be_bucheintragungen WHERE be_bucheintragungen.be_b_buch = " . @$row[0]);
	$sth2->execute();
	my $row2;
	while ($row2 = $sth2->fetchrow_arrayref())
	{
		push $pages, {nummer => @$row2[1], titel => @$row2[2]};
	}
	push $maps, { name => @$row[1], bid => @$row[0], seiten => $pages };
}

$sth->finish();
$dbh->disconnect();

my $jobj = JSON::XS->new->utf8->pretty(1);
my $output = $jobj->encode($maps);
print "Content-type: text/plain;<3 Kerstin <3\n\n";
my $path = substr(abs_path($0), 0, -2) . "json";
$path = dirname($path);
$path = dirname($path);
$path .= "/json/buecher.json";
#print ($path);
open OUTFILE, ">$path";
#binmode OUTFILE, ":encoding(UTF-8)";
print OUTFILE $output;
close OUTFILE;
print "OK";
