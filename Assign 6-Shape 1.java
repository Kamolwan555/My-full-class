package th.co.cdgs.shape;

public interface Shape {
    double getArea();

    class Square implements Shape {
        private double width;
        private double height;
    
        public Square(double width, double height) {
            this.width = width;
            this.height = height;
        }
    
        @Override
        public double getArea() {
            return width * height;
        }
    }
    
    class Triangle implements Shape {
        private double base;
        private double height;
    
        public Triangle(double base, double height) {
            this.base = base;
            this.height = height;
        }
    
        @Override
        public double getArea() {
            return 0.5 * base * height;
        }
    }

}
