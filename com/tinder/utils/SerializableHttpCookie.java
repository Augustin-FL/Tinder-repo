package com.tinder.utils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.HttpCookie;

public class SerializableHttpCookie implements Serializable {
    private static final long serialVersionUID = -6051428667568260064L;
    private transient HttpCookie f6510a;

    public SerializableHttpCookie(HttpCookie httpCookie) {
        this.f6510a = httpCookie;
    }

    public HttpCookie m9199a() {
        return this.f6510a;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.f6510a.getName());
        objectOutputStream.writeObject(this.f6510a.getValue());
        objectOutputStream.writeObject(this.f6510a.getComment());
        objectOutputStream.writeObject(this.f6510a.getCommentURL());
        objectOutputStream.writeBoolean(this.f6510a.getDiscard());
        objectOutputStream.writeObject(this.f6510a.getDomain());
        objectOutputStream.writeLong(this.f6510a.getMaxAge());
        objectOutputStream.writeObject(this.f6510a.getPath());
        objectOutputStream.writeObject(this.f6510a.getPortlist());
        objectOutputStream.writeBoolean(this.f6510a.getSecure());
        objectOutputStream.writeInt(this.f6510a.getVersion());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.f6510a = new HttpCookie((String) objectInputStream.readObject(), (String) objectInputStream.readObject());
        this.f6510a.setComment((String) objectInputStream.readObject());
        this.f6510a.setCommentURL((String) objectInputStream.readObject());
        this.f6510a.setDiscard(objectInputStream.readBoolean());
        this.f6510a.setDomain((String) objectInputStream.readObject());
        this.f6510a.setMaxAge(objectInputStream.readLong());
        this.f6510a.setPath((String) objectInputStream.readObject());
        this.f6510a.setPortlist((String) objectInputStream.readObject());
        this.f6510a.setSecure(objectInputStream.readBoolean());
        this.f6510a.setVersion(objectInputStream.readInt());
    }
}
