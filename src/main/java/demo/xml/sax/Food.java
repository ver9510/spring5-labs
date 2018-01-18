package demo.xml.sax;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Food {
    private int id;
    private String name;
    private String price;
    private String description;
    private int calories;
}
