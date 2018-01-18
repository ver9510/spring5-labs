package demo.xml.sax;

import lombok.SneakyThrows;
import lombok.val;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import javax.xml.parsers.SAXParserFactory;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class MenuSaxHandlerTest {
    @Test
    @SneakyThrows
    @DisplayName("parse method works correctly")
    void parse() {
//        XMLReader reader = XMLReaderFactory.createXMLReader();
        XMLReader reader = SAXParserFactory.newDefaultInstance().newSAXParser().getXMLReader();
        MenuSaxHandler handler = new MenuSaxHandler();
        reader.setContentHandler(handler);
        reader.parse(
                new InputSource("./src/main/resources/breakfast-menu.xml"));

        //noinspection unchecked
        val foodIterator = (Iterator<Food>) Mockito.mock(Iterator.class);
        Mockito.when(foodIterator.next())
                .thenReturn(new Food(
                        1,
                        "Belgian Waffles",
                        "$5.95",
                        "two of our famous Belgian Waffles with plenty of real maple syrup",
                        650))
                .thenReturn(new Food(2,
                        "Strawberry Belgian Waffles",
                        "$7.95",
                        "light Belgian waffles covered with strawberries and whipped cream",
                        900));

        for (Food food : handler.getFoodList())
            assertThat(food, is(foodIterator.next()));
    }
}