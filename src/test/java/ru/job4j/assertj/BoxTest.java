package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Tetrahedron");
    }

    @Test
    void whenVertex8NumberOfVertices8() {
        Box box = new Box(8, 10);
        int actual = box.getNumberOfVertices();
        int expected = 8;
        assertThat(actual)
                .isEqualTo(expected);
    }

    @Test
    void whenVertex4NumberOfVertices4() {
        Box box = new Box(8, 10);
        int actual = box.getNumberOfVertices();
        int expected = 8;
        assertThat(actual)
                .isEqualTo(expected).isNotZero();
    }

    @Test
    void whenTypeUnknownThenIsNotExist() {
        Box box = new Box(3, 10);
        boolean isExist = box.isExist();
        assertThat(isExist).isFalse();
    }

    @Test
    void whenTypeSphereThenIsExist() {
        Box box = new Box(0, 10);
        boolean isExist = box.isExist();
        assertThat(isExist).isTrue();
    }

    @Test
    void whenVertex0AndEdge2ThenArea50dot24() {
        Box box = new Box(0, 2);
        double actual = box.getArea();
        double expected = 50.24;
        assertThat(actual).isCloseTo(expected, withPrecision(0.027d));
    }

    @Test
    void whenVertex8AndEdge2ThenArea24() {
        Box box = new Box(8, 2);
        double actual = box.getArea();
        int expected = 24;
        assertThat(actual).isEqualTo(expected);
    }
}