#!/usr/bin/perl -w -l

use strict;
use DBI;
use JSON::XS;

my $dbh = DBI->connect("dbi:mysql:dbname=mvl","richi", "thispwdisnotsafe", {RaiseError => 1},) or die $DBI::errstr;

my $sth = $dbh->prepare("SELECT * FROM m_mitglieder LEFT JOIN i_instrumente i ON m_mitglieder.m_instrument = i.i_kuerzel");
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
print "Content-type: text/plain\n\n";
print $output;
