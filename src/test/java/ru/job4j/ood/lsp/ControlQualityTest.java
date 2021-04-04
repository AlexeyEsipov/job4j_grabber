package ru.job4j.ood.lsp;

import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class ControlQualityTest {

    @Test
    public void distributeWhen1Trash2Discount3Warehouse4Shop() {
        Store<Food> warehouseStore = new WarehouseStore<>();
        Store<Food> shopStore = new ShopStore<>();
        Store<Food> trashStore = new TrashStore<>();
        FoodWater w1 = new FoodWater("water1", LocalDate.of(2021, 1, 1),
                LocalDate.of(2021, 3, 31),
                25.00, 5.00);
        FoodWater w2 = new FoodWater("water2", LocalDate.of(2021, 1, 1),
                LocalDate.of(2021, 4, 5),
                25.00, 5.00);
        FoodBeer b1 = new FoodBeer("beer1", LocalDate.of(2021, 3, 31),
                LocalDate.of(2021, 12, 31),
                50.00, 15.00);
        FoodBeer b2 = new FoodBeer("beer2", LocalDate.of(2021, 1, 1),
                LocalDate.of(2021, 7, 1),
                50.00, 15.00);
        List<Food> listFood = List.of(w1, w2, b1, b2);
        ControlQuality<Food> cQ = new ControlQuality<>(warehouseStore, shopStore, trashStore);
        cQ.distribute(listFood, LocalDate.of(2021, 4, 3), 75, 25);
        assertEquals("water1", trashStore.getStore().get(0).getName());
        assertEquals(20.0, shopStore.getStore().get(0).getPrice(), 0.0001d);
        assertEquals("beer1", warehouseStore.getStore().get(0).getName());
        assertEquals("beer2", shopStore.getStore().get(1).getName());
    }
}