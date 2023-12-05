package Bai4;

public class MySphere {

    private double x;
    private double y;
    private double z;
    private double r;

    public MySphere() {}

    public MySphere(double x, double y, double z, double r) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.r = r;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double area() {
        return 4 * Math.PI * Math.pow(r,2);
    }

    public double volume() {
        return (4 * Math.PI * Math.pow(r,3)) / 3;
    }

    public boolean intersect(MySphere another) {
        double distance = Math.sqrt(Math.pow((this.x - another.x),2)
                                + Math.pow((this.y - another.y),2)
                                + Math.pow((this.z - another.z),2));
        if (distance <= (this.r + another.r) || distance >= Math.abs(this.r - another.r)) {
            return true;
        }
        return false;
    }

    public boolean cover(MySphere another) {
        double distance = Math.sqrt(Math.pow((this.x - another.x),2)
                                    + Math.pow((this.y - another.y),2)
                                    + Math.pow((this.z - another.z),2));
        if (distance < Math.abs(this.r - another.r) || distance == 0) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Sphere[Center(" + x + ","
                                + y + ","
                                + z + ")"
                                + "Radius=" + r + "]";
    }
}
