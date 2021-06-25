package com.group6.demo.repository;

import com.group6.demo.entity.item.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.IntStream.rangeClosed;

@SpringBootTest
class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void MakeDummies() throws Exception{
        rangeClosed(1,30).forEach(i ->{
            Item item =Item.builder()
                    .stock((int) (Math.random() *15+1))
                    .price((int) ((Math.random() *20+1)*100))
                    .thumbImg("testImg"+i)
                    .writer("writer"+i)
                    .content("testcontent"+i)
                    .title("testTitle"+i)
                    .type("A")
                    .build();

            itemRepository.save(item);
        });
        rangeClosed(1,30).forEach(i ->{
            Item item =Item.builder()
                    .stock((int) (Math.random() *15+1))
                    .price((int) ((Math.random() *20+1)*100))
                    .thumbImg("testImg"+i)
                    .writer("writer"+i)
                    .content("testcontent"+i)
                    .title("testTitle"+i)
                    .type("B")
                    .build();

            itemRepository.save(item);
        });
    }



    @Test
    public void UpdateTest() throws Exception{
        Optional<Item> result = itemRepository.findById(200L);

        Item item = result.get();
        System.out.println("item.get = " + item.getUploadDate());
        System.out.println("item.get = " + item.getType());
        System.out.println("item.get = " + item.getPrice());
     }



     @Test
     public void testQuery() throws Exception{

         Pageable pageable = PageRequest.of(0,10, Sort.by("id").descending());

         System.out.println(pageable.toString());

      }



      @Test
      public void gsd() throws Exception{
          Optional<String> sdfa = Optional.empty();//given

          if (sdfa.isPresent()){
              System.out.println("나오면 null아닌거");
          }else {
              System.out.println("나오면 null인거");
          }


       }



       @Test
       public void find() throws Exception{
           //given
           List<Item> result =itemRepository.findByTitleContaining("t");
           ArrayList<String> list = new ArrayList<>();
           int flag = 0;
           for (Item items : result) {
               list.add(items.getTitle());
               flag++;
               System.out.println("items.getTitle() = " + items.getTitle());
               if (list.isEmpty() || flag >= 10){
                   System.out.println("break");
                   break;
               }
           }
           System.out.println(list.toString());
        }
}
