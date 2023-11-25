package ru.job4j.ood.isp;

/*
Принтер не поддерживает чтение данных, но метод должен быть реализован из-за интерфейса
 */
class Printer implements ReadWriteDevice {
    @Override
    public void readData() {
        throw new UnsupportedOperationException("Printers can't read data!");
    }

    @Override
    public void writeData() {
        System.out.println("writing");
    }
}
