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

package net.ilexiconn.magister.adapter.sub;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import net.ilexiconn.magister.Magister;
import net.ilexiconn.magister.container.sub.Link;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LinkAdapter extends TypeAdapter<Link[]> {
    public Magister magister;

    public LinkAdapter(Magister m) {
        magister = m;
    }

    public void write(JsonWriter jsonWriter, Link[] value) throws IOException {
        throw new UnsupportedOperationException("Not implemented");
    }

    public Link[] read(JsonReader jsonReader) throws IOException {
        List<Link> linkList = new ArrayList<>();
        for (JsonElement element : magister.gson.getAdapter(JsonElement.class).read(jsonReader).getAsJsonArray()) {
            JsonObject object = element.getAsJsonObject();
            String href = object.has("href") ? object.get("href").getAsString() : object.get("Href").getAsString();
            String rel = object.has("rel") ? object.get("rel").getAsString() : object.get("Rel").getAsString();
            linkList.add(new Link(href, rel));
        }
        return linkList.toArray(new Link[linkList.size()]);
    }
}