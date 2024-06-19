package nl.bryansuk.foundationapi.menutemplate;

import nl.bryansuk.foundationapi.menuitems.MenuItem;

import java.util.Map;

public record Template(String identifier, Map<Integer, MenuItem> getMenuItems) {}
