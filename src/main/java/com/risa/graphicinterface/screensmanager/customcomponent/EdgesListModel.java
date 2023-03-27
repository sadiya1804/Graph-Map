package com.risa.graphicinterface.screensmanager.customcomponent;

import com.risa.functionality.compare.filter.EdgeFilters;
import com.risa.graph.Arete;
import com.risa.graph.TypeRoute;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;

public class EdgesListModel extends AbstractListModel<Arete> implements ComboBoxModel<Arete>, ListModel<Arete> {
    private final ArrayList<Arete> edges = new ArrayList<>();
    private Arete selected = null;

    public EdgesListModel() {
        super();
    }

    /**
     * Permet de changer l'élément actuellement sélectionné.
     * @param anItem the list object to select or <code>null</code>
     *        to clear the selection
     */
    @Override
    public void setSelectedItem(Object anItem) {
        if (anItem instanceof Arete) {
            selected = (Arete) anItem;
        } else {
            selected = null;
        }
    }

    /**
     * Permet de récupérer l'élément sélectionné.
     * @return Edge (Cast requis)
     */
    @Override
    public Object getSelectedItem() {
        return selected;
    }

    /**
     * Retourne le nombre d'éléments contenu par le model.
     * @return int
     */
    @Override
    public int getSize() {
        return edges.size();
    }

    /**
     * @param index the requested index
     * @return Arete
     */
    @Override
    public Arete getElementAt(int index) {
        return edges.get(index);
    }

    /**
     * Permet d'ajouter un élément au model.
     * @param edge une arête
     */
    public void addEdge(Arete edge) {
        if (edge != null) {
            edges.add(edge);
            fireIntervalAdded(edge, edges.size(), edges.size());
        }
    }

    /**
     * Permet d'enlever un élément au model.
     * @param edge une arête
     */
    public void removeEdge(Arete edge) {
        int i = edges.indexOf(edge);
        edges.remove(edge);
        fireIntervalRemoved(edges, i, i);
    }

    /**
     * Permet de remplir le model avec la liste d'arêtes passé en paramètre.
     * @param edges liste d'arêtes
     */
    public void fill(Collection<Arete> edges) {
        for (Arete edge : edges) {
            addEdge(edge);
        }
    }

    /**
     * Vide entièrement le model.
     */
    public void emptyAll() {
        if (! edges.isEmpty()) {
            int size = edges.size();
            edges.clear();
            fireIntervalRemoved(edges, 0, size);
        }
    }

    /**
     * Permet de re-remplir le model avec un filtre donné et de nouvelles arêtes.
     * @param typeRoute filtre
     * @param edges nouvelle liste d'arêtes
     */
    public void filterBy(TypeRoute typeRoute, Collection<Arete> edges) {
        EdgeFilters filter = new EdgeFilters();
        ArrayList<Arete> filteredEdges = filter.filterCustomized(edges, typeRoute);

        emptyAll();
        fill(filteredEdges);
    }

    @Override
    protected void fireIntervalAdded(Object source, int index0, int index1) {
        super.fireIntervalAdded(source, index0, index1);
    }

    @Override
    protected void fireIntervalRemoved(Object source, int index0, int index1) {
        super.fireIntervalRemoved(source, index0, index1);
    }
}
