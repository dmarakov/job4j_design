package ru.job4j.generics;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RoleStoryTest {

    @Test
    void whenAddAndFindThenRoleIsAdministrator() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Administrator"));
        Role result = store.findById("1");
        assertThat(result.getName()).isEqualTo("Administrator");
    }

    @Test
    void whenAddAndFindThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Administrator"));
        Role result = store.findById("10");
        assertThat(result).isNull();
    }

    @Test
    void whenAddDuplicateAndFindRoleIsAdministrator() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Administrator"));
        store.add(new Role("1", "Developer"));
        Role result = store.findById("1");
        assertThat(result.getName()).isEqualTo("Administrator");
    }

    @Test
    void whenReplaceThenRoleIsDeveloper() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Administrator"));
        store.replace("1", new Role("1", "Developer"));
        Role result = store.findById("1");
        assertThat(result.getName()).isEqualTo("Developer");
    }

    @Test
    void whenNoReplaceRoleThenNoChangeName() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Administrator"));
        store.replace("10", new Role("10", "Developer"));
        Role result = store.findById("1");
        assertThat(result.getName()).isEqualTo("Administrator");
    }

    @Test
    void whenDeleteRoleThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Administrator"));
        store.delete("1");
        Role result = store.findById("1");
        assertThat(result).isNull();
    }

    @Test
    void whenNoDeleteRoleThenNameIsAdministrator() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Administrator"));
        store.delete("10");
        Role result = store.findById("1");
        assertThat(result.getName()).isEqualTo("Administrator");
    }

    @Test
    void whenReplaceRoleOkThenTrue() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Administrator"));
        boolean rsl = store.replace("1", new Role("1", "Developer"));
        assertThat(rsl).isTrue();
    }

    @Test
    void whenReplaceRoleNotOkThenFalse() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Administrator"));
        boolean rsl = store.replace("10", new Role("10", "Developer"));
        assertThat(rsl).isFalse();
    }

    @Test
    void whenDeleteRoleOkThenTrue() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Administrator"));
        boolean rsl = store.delete("1");
        assertThat(rsl).isTrue();
    }

    @Test
    void whenDeleteRoleNotOkThenFalse() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Administrator"));
        boolean rsl = store.delete("2");
        assertThat(rsl).isFalse();
    }
}
