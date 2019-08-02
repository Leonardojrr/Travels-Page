
package models;

import java.util.ArrayList;



public class FlightListModel {
    private ArrayList<String> salidas = new ArrayList<>();
    private ArrayList<String> destinos = new ArrayList<>();

    /**
     * @return the salidas
     */
    public ArrayList<String> getSalidas() {
        return salidas;
    }

    /**
     * @param salidas the salidas to set
     */
    public void setSalidas(ArrayList<String> salidas) {
        this.salidas = salidas;
    }

    /**
     * @return the destinos
     */
    public ArrayList<String> getDestinos() {
        return destinos;
    }

    /**
     * @param destinos the destinos to set
     */
    public void setDestinos(ArrayList<String> destinos) {
        this.destinos = destinos;
    }

    
}
