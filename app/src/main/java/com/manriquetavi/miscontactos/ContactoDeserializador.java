package com.manriquetavi.miscontactos;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ContactoDeserializador implements JsonDeserializer<ContactoResponse> {

    @Override
    public ContactoResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        ContactoResponse contactoResponse = gson.fromJson(json, ContactoResponse.class);
        JsonArray contactoResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);
        contactoResponse.setContactos(deserializarContactoJson(contactoResponseData));
        return contactoResponse;
    }

    private ArrayList<Contacto> deserializarContactoJson(JsonArray contactoResponseData){
        ArrayList<Contacto> contactos = new ArrayList<>();
        for (int i = 0; i < contactoResponseData.size(); i++) {
            JsonObject contactoResponseDataObject   = contactoResponseData.get(i).getAsJsonObject();
            String id                               = contactoResponseDataObject.get(JsonKeys.MEDIA_ID).getAsString();
            String foto                             = contactoResponseDataObject.get(JsonKeys.MEDIA_URL_FOTO).getAsString();
            int likes                               = contactoResponseDataObject.get(JsonKeys.MEDIA_LIKE_COUNT).getAsInt();
            Contacto contactoActual = new Contacto();
            contactoActual.setId(id);
            contactoActual.setUrlFoto(foto);
            contactoActual.setLikes(likes);
            contactos.add(contactoActual);
        }
        return contactos;
    }
}
