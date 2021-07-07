package com.manriquetavi.miscontactos;

public final class ConstantesRestApi {
    public static final String VERSION = "/v11.0/";
    public static final String ROOT_URL = "https://graph.facebook.com" + VERSION;
    public static final String ACCESS_TOKEN = "EAANEUbQmIqQBACpQVuo1PYKhgaorfwJ8zYlK0H8ZAzTnL3vZCgZCNQYl5znw0b6U9Qm0BqvQyEuboAVeP08vfjW5YLhjZCmodyXtDsZBISlPEZC9kGdCd2VZAOEZA9zqYKZBy3DWxD6KHBTRuBWNWthEfD5zZB839n7NhAcKzLbZCyIerrTzLZCF0cGZC";
    public static final String KEY_ACCESS_TOKEN = "&access_token=";
    public static final String USER_ID = "17841448623463973";
    public static final String KEY_USER_MEDIA = "/media?fields=id,media_type,media_url,owner,username,like_count,owner,timestamp";
    public static final String URL_USER_MEDIA = USER_ID + KEY_USER_MEDIA + KEY_ACCESS_TOKEN + ACCESS_TOKEN;

    public static final String KEY_BIO_URL = "?fields=biography,followers_count,follows_count,name,media_count,username,profile_picture_url";
    public static final String URL_USER_BIO = USER_ID + KEY_BIO_URL+ KEY_ACCESS_TOKEN + ACCESS_TOKEN;
}
