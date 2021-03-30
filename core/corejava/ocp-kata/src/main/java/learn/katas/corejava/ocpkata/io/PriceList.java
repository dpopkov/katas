package learn.katas.corejava.ocpkata.io;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class PriceList implements Serializable {

    private LocalDate date;
    private Set<Product> items = new HashSet<>();
    private transient String hash;

    public PriceList(LocalDate date) throws IOException, NoSuchAlgorithmException {
        this.date = date;
        hash = generateHash();
    }

    public void addItem(Product item) {
        items.add(item);
    }

    public Set<Product> getItems() {
        return items;
    }

    public void setItems(Set<Product> items) {
        this.items = items;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getHash() {
        return hash;
    }

    private String generateHash() throws IOException, NoSuchAlgorithmException {
        String hash = null;
        try (ByteArrayOutputStream byteArrayOutput = new ByteArrayOutputStream();
             ObjectOutputStream out = new ObjectOutputStream(byteArrayOutput)) {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            out.writeObject(this);
            hash = new BigInteger(1, md.digest()).toString(16);
        }
        return hash;
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        try {
            this.hash = generateHash();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        PriceList priceList = (PriceList) other;
        return Objects.equals(date, priceList.date) &&
                Objects.equals(items, priceList.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, items);
    }
}
