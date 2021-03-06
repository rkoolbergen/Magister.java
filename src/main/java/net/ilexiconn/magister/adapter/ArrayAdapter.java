/*
 * Copyright (c) 2015 iLexiconn
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */

package net.ilexiconn.magister.adapter;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import net.ilexiconn.magister.util.GsonUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayAdapter<T> extends TypeAdapter<T[]> {
    public Gson gson = GsonUtil.getGson();
    public Class<T> cls;
    public Class<? extends T[]> clsArray;

    public ArrayAdapter(Class<T> cls, Class<? extends T[]> clsArray) {
        this.cls = cls;
        this.clsArray = clsArray;
    }

    @Override
    public void write(JsonWriter out, T[] value) throws IOException {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public T[] read(JsonReader in) throws IOException {
        JsonObject object = gson.getAdapter(JsonElement.class).read(in).getAsJsonObject();
        if (object.has("Items")) {
            JsonArray array = object.get("Items").getAsJsonArray();
            ArrayList<T> list = new ArrayList<T>();
            for (JsonElement element : array) {
                list.add(gson.fromJson(element, cls));
            }
            return Arrays.copyOf(list.toArray(), list.size(), clsArray);
        } else {
            T t = gson.fromJson(object, cls);
            return (T[]) new Object[]{t};
        }
    }
}
