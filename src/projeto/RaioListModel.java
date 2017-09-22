package projeto;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class RaioListModel implements ListModel<Raio> {

    private final List<Raio> raios;
    
    private final List<ListDataListener> dataListeners;

    public RaioListModel(List<Raio> raio) {
        this.raios = raio;
        this.dataListeners =  new ArrayList<>();
    }

    @Override
    public int getSize() {
        return raios.size();
    }

    @Override
    public Raio getElementAt(int index) {
        return raios.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        this.dataListeners.add(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        this.dataListeners.remove(l);
    }
    
}
