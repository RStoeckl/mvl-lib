/*
 * <one line to give the program's name and a brief idea of what it does.>
 * Copyright (C) 2015  Richard Stöckl <richard.stoeckl@aon.at>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 */
#include <string>


#ifndef TERMIN_H
#define TERMIN_H

using namespace std;

class Termin
{
public:
    Termin();
    Termin(const Termin& other);
    ~Termin();
    Termin& operator=(const Termin& other);
    bool operator==(const Termin& other) const;
    string getName();
    string getDauer();
    string getTreffpunkt();
    string getBeschreibung();
    string getAdjustierung();
    long getBeginn();
private:
  string name;
  string dauer;
  string treffpunkt;
  string beschreibung;
  string adjustierung;
  long beginn;
};

#endif // TERMIN_H
