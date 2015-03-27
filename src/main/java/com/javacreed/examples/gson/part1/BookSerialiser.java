/*
 * #%L
 * Gson Serialiser Example
 * %%
 * Copyright (C) 2012 - 2015 Java Creed
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.javacreed.examples.gson.part1;

import java.lang.reflect.Type;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class BookSerialiser implements JsonSerializer<Book> {

  @Override
  public JsonElement serialize(final Book book, final Type typeOfSrc, final JsonSerializationContext context) {
    final JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("title", book.getTitle());
    jsonObject.addProperty("isbn-10", book.getIsbn10());
    jsonObject.addProperty("isbn-13", book.getIsbn13());

    final JsonArray jsonAuthorsArray = new JsonArray();
    for (final String author : book.getAuthors()) {
      final JsonPrimitive jsonAuthor = new JsonPrimitive(author);
      jsonAuthorsArray.add(jsonAuthor);
    }
    jsonObject.add("authors", jsonAuthorsArray);

    return jsonObject;
  }
}
