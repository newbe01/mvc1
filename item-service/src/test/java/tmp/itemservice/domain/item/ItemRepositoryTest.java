package tmp.itemservice.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach() {
        itemRepository.clearStore();
    }

    @Test
    void save() {
        // given
        Item item = new Item("itemA", 10000, 10);

        // when
        Item savedItem = itemRepository.save(item);

        // then
        Item result = itemRepository.findById(savedItem.getId());
        assertThat(result).isEqualTo(savedItem);
    }

    @Test
    void findAll() {
        // given
        Item item1 = new Item("itemA", 10000, 10);
        Item item2 = new Item("itemB", 20000, 20);

        // when
        itemRepository.save(item1);
        itemRepository.save(item2);

        // then
        List<Item> result = itemRepository.findAll();
        assertThat(result).hasSize(2);
        assertThat(result).contains(item1, item2);
    }

    @Test
    void updateItem() {
        // given
        Item item = new Item("itemA", 10000, 10);
        Item savedItem = itemRepository.save(item);
        Long itemId = savedItem.getId();

        // when
        Item updateParam = new Item("itemB", 20000, 20);
        itemRepository.update(itemId, updateParam);

        // then
        Item result = itemRepository.findById(itemId);
        assertThat(result.getItemName()).isEqualTo(updateParam.getItemName());
        assertThat(result.getPrice()).isEqualTo(updateParam.getPrice());
        assertThat(result.getQuantity()).isEqualTo(updateParam.getQuantity());

    }
    
}