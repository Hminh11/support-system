/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ^Zin^
 */
public class Detail {
    int productid;
    int numPr;
    String size;

    public Detail() {
    }

    public Detail(int productid, int numPr, String size) {
        this.productid = productid;
        this.numPr = numPr;
        this.size = size;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public int getNumPr() {
        return numPr;
    }

    public void setNumPr(int numPr) {
        this.numPr = numPr;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
    

   
}
