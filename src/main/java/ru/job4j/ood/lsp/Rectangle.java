package ru.job4j.ood.lsp;

/*
Т.к в классе Square высота и ширина одинаковые, то мы переопределили сеттеры для обоих переменных.
Однако теперь, если объект класса Square подставить вместо Rectangle, то при расчете площади мы получим некорректное число.
 */
class Rectangle {
    protected int width;
    protected int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int calculateArea() {
        return width * height;
    }

    static class Square extends Rectangle {
        @Override
        public void setWidth(int width) {
            this.width = width;
            this.height = width;
        }

        @Override
        public void setHeight(int height) {
            this.width = height;
            this.height = height;
        }

        public static void main(String[] args) {
            Rectangle rectangle = new Square();
            rectangle.setWidth(5);
            rectangle.setHeight(10);
            int area = rectangle.calculateArea();
            System.out.println("Area: " + area);
        }
    }
}
