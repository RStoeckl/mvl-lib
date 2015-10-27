#!/usr/bin/perl -w -l

use File::Basename;
use Cwd 'abs_path';
use strict;
use DBI;
use JSON::XS;

my $dbh = DBI->connect("dbi:mysql:dbname=mvl","richi", "thispwdisnotsafe", {RaiseError => 1},) or die $DBI::errstr;

my $sth = $dbh->prepare("SELECT * FROM be_bucheintragungen LEFT JOIN b_buecher b ON be_bucheintragungen.be_b_buch = b.b_id");
$sth->execute();

my $maps = [];
my $row;
while ($row = $sth->fetchrow_arrayref())
{
	push $maps, { vorname => @$row[2], familienname => @$row[1], beitritt => @$row[4], instrument => @$row[11] };
}

$sth->finish();
$dbh->disconnect();

my $jobj = JSON::XS->new->utf8->pretty(1);
my $output = $jobj->encode($maps);
print "Content-type: text/plain;Charset: utf-8\n\n";
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
