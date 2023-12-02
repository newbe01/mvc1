package tmp.itemservice.web.basic;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tmp.itemservice.domain.item.Item;
import tmp.itemservice.domain.item.ItemRepository;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/basic/items")
@Controller
public class BasicItemController {

    private final ItemRepository itemRepository;

    @GetMapping
    public String items(Model model) {

        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "basic/items";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable("itemId") long itemId, Model model) {

        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);

        return "basic/item";
    }

    @GetMapping("/add")
    public String addForm() {
        return "basic/addForm";
    }

//    @PostMapping("/add")
    public String addItemV1(
            @RequestParam("itemName") String itemName,
            @RequestParam("price") int price,
            @RequestParam("quantity") Integer quantity,
            Model model)
    {

        Item item = new Item();
        item.setItemName(itemName);
        item.setPrice(price);
        item.setQuantity(quantity);

        itemRepository.save(item);
        model.addAttribute("item", item);

        return "basic/item";
    }

    @PostMapping("/add")
//    public String addItemV2(@ModelAttribute("item") Item item, Model model) { > 아래로 변경가능
//    public String addItemV2(@ModelAttribute Item item) {
    public String addItemV2(Item item) {    // modelAttribute 생략 가능

        itemRepository.save(item);
//        model.addAttribute("item", item); modelAttribute 에서 처리해줌

        return "basic/item";
    }


    @PostConstruct
    public void init() {
        itemRepository.save(new Item("itemTest", 10000, 10));
    }

}
