package com.risa.graphicinterface.graphstream;

public class Stylesheets {

    private final String backgroundColor = "#3C3F41";
    private final String edgesColor = "#00AFB5";
    private final String restaurantsColor = "#FF7700";
    private final String citiesColor = "#9EE493";
    private final String leisureCentersColor = "#F6D851";
    private final String showedColor = "#FFF9FB";


    private String GraphStyle() {
        return """
                graph {
                    padding: 40px;
                    fill-color: backgroundColor;
                }
                """
                .replace("backgroundColor", backgroundColor);
    }

    private String NodeStyle() {
        return """
                node {
                    size: 20px;
                    text-alignment: above;
                    text-size: 10;
                    text-padding: 4px, 0px;
                    text-style: bold;
                    text-color: #F2F7F2;
                    text-background-color: #493732;
                    text-background-mode: rounded-box;
                    text-offset: 0, -15;
                }
                
                node:selected {
                    fill-color: showedColor;
                }
                
                node:clicked {
                    fill-color: showedColor;
                    size: 25px;
                }
                
                node.city {
                    shape: rounded-box;
                    fill-color: citiesColor;
                }
                
                node.restaurant {
                    shape: circle;
                    fill-color: restaurantsColor;
                }
                
                node.leisurecenter {
                    shape: diamond;
                    fill-color: leisureCentersColor;
                }
                
                node.showed {
                    fill-color: showedColor;
                    size: 23px;
                }
                """
                .replace("restaurantsColor", restaurantsColor)
                .replace("citiesColor", citiesColor)
                .replace("leisureCentersColor", leisureCentersColor)
                .replace("showedColor", showedColor);
    }

    private String EdgeStyle() {
        return """
                edge {
                    fill-color: edgesColor;
                    text-size: 9;
                    text-style: bold;
                    text-color: #F2F7F2;
                    text-alignment: above;
                    text-background-mode: rounded-box;
                    text-background-color: #493732;
                    text-padding: 2px, 0px;
                }
                
                edge:selected {
                    fill-color: showedColor;
                }
                
                edge:clicked {
                    fill-color: showedColor;
                }
                
                edge.showed {
                    fill-color: showedColor;
                    size: 3px;
                }
                """
                .replace("edgesColor", edgesColor)
                .replace("showedColor", showedColor);
    }

    @Override
    public String toString() {
        return (GraphStyle() + NodeStyle() + EdgeStyle())
                .replace("showedColor", showedColor);
    }
}
