package latihab;
import java.util.Arrays;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Erlang Anggara
 */
public class Graf {
 static String[] kota = {"A","B","C","D","E","F"};
 
 static boolean[][] undigraph = {
     {false,true,true,false,true,false},
     {true,false,true,true,false,false},
     {true,true,false,false,true,true},
     {false,true,false,false,false,false},
     {true,false,true,false,false,false},
     {false,false,true,false,false,false},
 };
 
 static boolean[][] digraph = {
     {false,true,true,false,false,false},
     {false,false,true,false,false,false},
     {false,false,false,false,true,true},
     {false,true,false,false,false,false},
     {true,false,true,false,false,false},
     {false,false,false,false,false,false},
 };
 
 static void printUnAndDigraph(boolean[][] edges){
  if (Arrays.equals(edges,undigraph)){
      System.out.println("Edges Of Undigraph");
  } 
  if(Arrays.equals(edges, digraph)){
      System.out.println("Edges Of Digraph");
  }
  for(int i = 0; i < 6; i++){
      for(int j = 0; j < 6; j++){
          if(edges[i][j]){
              if (Arrays.equals(edges, undigraph)){
                  System.out.println("("+kota[i]+","+kota[j]+")");
              }
              if (Arrays.equals(edges, digraph)){
                  System.out.println("<"+kota[i]+","+kota[j]+">");
              }
          }
      }
  }
     System.out.println("\n\n");
 }
 
 static int [][] weighted = {
     {0,5,4,0,11,0},
     {5,0,7,3,0,0},
     {4,7,0,0,6,4},
     {0,3,0,0,0,0},
     {11,0,6,0,0,0},
     {0,0,4,0,0,0},
 };
 
 static void printWeightedGraph(int[][] edges){
     System.out.println("Edges Of weighted Graph");
     for(int i = 0; i < 6; i++){
         for(int j = 0; j < 6; j++){
             if(edges[i][j] !=0){
                 System.out.println("("+kota[i]+","+kota[j]+") = "+edges[i][j]);
             }
         }
     }
     System.out.println("\n\n");
 }
 static void addEdgeGraph(String sumber, String tujuan, boolean[][] edges) {
        int indexSumber = -1;
        int indexTujuan = -1;

        for (int perulangan = 0; perulangan < edges.length; perulangan++) {
            if (kota[perulangan].equals(sumber)) {
                indexSumber = perulangan;
                break;
            }
        }

        for (int perulangan = 0; perulangan < edges.length; perulangan++) {
            if (kota[perulangan].equals(tujuan)) {
                indexTujuan = perulangan;
                break;
            }
        }

        if (indexSumber < 0 && indexTujuan < 0) {
            System.out.println("Sumber dan tujuan tidak ditemukan.");
        } else if (indexSumber < 0) {
            System.out.println("Sumber tidak ditemukan");
        } else if (indexTujuan < 0) {
            System.out.println("Tujuan tidak ditemukan");
        } else {

            if (Arrays.equals(edges, undigraph)) {
                undigraph[indexSumber][indexTujuan] = true;
                undigraph[indexTujuan][indexSumber] = true;
                System.out.println("Penambahan Edge Undirectedgraph");
            }

            if (Arrays.equals(edges, digraph)) {
                digraph[indexSumber][indexTujuan] = true;
                System.out.println("Penambahan Edge directgraph");
            }

            System.out.println("Vertex " + sumber + " Berhasil dihubungkan dengan vertex " + tujuan + "\n\n");
        }
    }

    static void addEdgeWeightedGraph(String sumber, String tujuan, int nilai, int[][] edges) {
        int indexSumber = -1;
        int indexTujuan = -1;

        for (int perulangan = 0; perulangan < edges.length; perulangan++) {
            if (kota[perulangan].equals(sumber)) {
                indexSumber = perulangan;
                break;
            }
        }

        for (int perulangan = 0; perulangan < edges.length; perulangan++) {
            if (kota[perulangan].equals(tujuan)) {
                indexTujuan = perulangan;
                break;
            }
        }

        if (indexSumber < 0 && indexTujuan < 0) {
            System.out.println("Sumber dan tujuan tidak ditemukan.");
        } else if (indexSumber < 0) {
            System.out.println("Sumber tidak ditemukan");
        } else if (indexTujuan < 0) {
            System.out.println("Tujuan tidak ditemukan");
        } else {
            weighted[indexSumber][indexTujuan] = nilai;
            weighted[indexTujuan][indexSumber] = nilai;
            System.out.println(
                    "Penambahan edges di weighted Graph : Vertex " + sumber +
                            " berhasil dihubungkan dengan vertex " + tujuan + " dengan nilai : " + nilai + "\n\n");
        }
    }

    static int getWeightedValueVerticesUndirectGraph(
            String rowValue,
            String columnValue,
            int[][] edges,
            boolean[][] unDirectGraph,
            String[] kota) {
        int indexBaris = -1;
        int indexKolom = -1;
        int nilaiDituju = 0;

        // Mencari index baris yang memiliki Huruf sesuai dengan parameter
        for (int perulangan = 0; perulangan < unDirectGraph.length; perulangan++) {
            if (kota[perulangan].equals(rowValue)) {
                indexBaris = perulangan;
                break;
            }
        }

        // Mencari index kolom yang memiliki Huruf sesuai dengan parameter
        for (int perulangan = 0; perulangan < unDirectGraph.length; perulangan++) {
            if (kota[perulangan].equals(columnValue)) {
                indexKolom = perulangan;
                break;
            }
        }

        // Perulangan untuk mencari nilai bobot pada vertex menggunakan indeks yang telah didapat diatas.
        for (int kolom = 0; kolom < edges.length; kolom++) {
            for (int baris = 0; baris < edges[kolom].length; baris++) {
                if (edges[kolom][baris] != 0) {
                    if (indexBaris == baris && indexKolom == kolom) {
                        nilaiDituju = edges[indexKolom][indexBaris];
                    }
                }
            }
            System.out.println();
        }

        return nilaiDituju;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        printUnAndDigraph(undigraph);
        printUnAndDigraph(digraph);
        printWeightedGraph(weighted);

        addEdgeGraph("A", "D", undigraph);
        printUnAndDigraph(undigraph);
        printUnAndDigraph(digraph);
        addEdgeWeightedGraph("A", "D", 2, weighted);
        addEdgeGraph("A", "D", digraph);
        printWeightedGraph(weighted);
        int bobotVertexAB = getWeightedValueVerticesUndirectGraph("A", "B", weighted, undigraph, kota);
        int bobotVertexBC = getWeightedValueVerticesUndirectGraph("B", "C", weighted, undigraph, kota);

        int jumlahBobotVertexABdanBC = bobotVertexAB + bobotVertexBC;
        System.out.println("Jumlah Bobot Vertex AB dan BC: " + jumlahBobotVertexABdanBC);

    }
    
}
