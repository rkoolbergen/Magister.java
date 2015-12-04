/*
 * Copyright (c) 2015 iLexiconn
 *
 *  Permission is hereby granted, free of charge, to any person
 *  obtaining a copy of this software and associated documentation
 *  files (the "Software"), to deal in the Software without
 *  restriction, including without limitation the rights to use,
 *  copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the
 *  Software is furnished to do so, subject to the following
 *  conditions:
 *
 *  The above copyright notice and this permission notice shall be
 *  included in all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *  EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 *  OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *  NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 *  HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 *  WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 *  FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 *  OTHER DEALINGS IN THE SOFTWARE.
 */

package net.ilexiconn.magister.container;

import com.google.gson.annotations.SerializedName;
import net.ilexiconn.magister.container.sub.Link;
import net.ilexiconn.magister.container.sub.Privilege;

public class Presence {
    @SerializedName("Id")
    public int id;

    @SerializedName("Start")
    public String start;

    @SerializedName("Eind")
    public String end;

    @SerializedName("Lesuur")
    public int period;

    @SerializedName("Geoorloofd")
    public boolean isAllowed;

    @SerializedName("AfspraakId")
    public int appointmentId;

    @SerializedName("Omschrijving")
    public String description;

    @SerializedName("Verantwoordingtype")
    public int accountabilityType;

    @SerializedName("Code")
    public String code;

    @SerializedName("Afspraak")
    public Appointment appointment;

}
