package com.risa.graphicinterface.screensmanager.customcomponent;

import com.risa.functionality.compare.filter.NodeFilters;
import com.risa.graph.Noeud;
import com.risa.graph.TypeLieu;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;

public class NodesListModel extends AbstractListModel<Noeud> implements ComboBoxModel<Noeud>, ListModel<Noeud> {
    private final ArrayList<Noeud> nodes = new ArrayList<>();
    private Noeud selected = null;

    public NodesListModel() {
        super();
    }

    /**
     * Permet de changer l'élément actuellement sélectionné.
     * @param anItem the list object to select or <code>null</code>
     *        to clear the selection
     */
    @Override
    public void setSelectedItem(Object anItem) {
        if (anItem instanceof Noeud) {
            selected = (Noeud) anItem;
        } else {
            selected = null;
        }
    }

    /**
     * Permet de récupérer l'élément sélectionné.
     * @return Noeud (Cast requis)
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
        return nodes.size();
    }

    /**
     * @param index the requested index
     * @return Noeud
     */
    @Override
    public Noeud getElementAt(int index) {
        return nodes.get(index);
    }

    /**
     * Permet d'ajouter un élément au model.
     * @param node un noeud
     */
    public void addNode(Noeud node) {
        if (node != null) {
            nodes.add(node);
            fireIntervalAdded(node, nodes.size(), nodes.size());
        }
    }

    /**
     * Permet d'enlever un élément au model.
     * @param node un noeud
     */
    public void removeNode(Noeud node) {
        int i = nodes.indexOf(node);
        nodes.remove(node);
        fireIntervalRemoved(nodes, i, i);
    }

    /**
     * Permet de remplir le model avec la liste de neouds passé en paramètre.
     * @param nodes liste de noeuds
     */
    public void fill(Collection<Noeud> nodes) {
        for (Noeud node : nodes) {
            addNode(node);
        }
    }

    /**
     * Vide entièrement le model.
     */
    public void emptyAll() {
        if (! nodes.isEmpty()) {
            int size = nodes.size();
            nodes.clear();
            fireIntervalRemoved(nodes, 0, size);
        }
    }

    /**
     * Permet de re-remplir le model avec un filtre donné et de nouveaux noeuds.
     * @param typeLieu filtre
     * @param nodes nouvelle liste de noeuds
     */
    public void filterBy(TypeLieu typeLieu, Collection<Noeud> nodes) {
        NodeFilters filter = new NodeFilters();
        ArrayList<Noeud> filteredNodes = filter.filterCustomized(nodes, typeLieu);

        emptyAll();
        fill(filteredNodes);

        if (filteredNodes.isEmpty()) {
            addNode(new Noeud("Aucun", null));
        }
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
