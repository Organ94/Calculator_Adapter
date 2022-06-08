package Logger;

import Interfaces.IStorage;

import java.util.List;

public class ListStorageAdapter implements IStorage {

    private List<String> list;

    public ListStorageAdapter(List<String> list) {
        this.list = list;
    }

    @Override
    public void append(String msg) {
        list.add(msg);
    }
}
