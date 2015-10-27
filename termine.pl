#!/usr/bin/perl -w -l


use File::Basename;
use strict;
use DBI;
use JSON::XS;
use Cwd 'abs_path';
use warnings;

my $dbh = DBI->connect("dbi:mysql:dbname=mvl","richi", "thispwdisnotsafe", {RaiseError => 1},) or die $DBI::errstr;

my $sth = $dbh->prepare("SELECT * FROM t_termine LEFT JOIN a_adjustierung a ON t_termine.t_a_adjustierung = a.a_id");
$sth->execute();

my $maps = [];
my $row;
my $stamp = localtime(time);
push $maps, { timestamp => $stamp };
while ($row = $sth->fetchrow_arrayref())
{
	push $maps, { id => @$row[0], name => @$row[1], dauer => @$row[2], beginn => @$row[3], treffpunkt => @$row[4], beschreibung => @$row[5], adjid => @$row[6], adjustierung => @$row[8] };
}

$sth->finish();
$dbh->disconnect();

my $jobj = JSON::XS->new->utf8->pretty(1);
my $output = $jobj->encode($maps);
print "Content-type: text/plain\n\n";
my $path = substr(abs_path($0), 0, -2) . "json";
$path = dirname( $path );
$path = dirname ( $path );
$path .= "/json/termine.json";
#print ($path);
print ("OK");
open OUTFILE, ">$path";
print OUTFILE $output;
close OUTFILE;
