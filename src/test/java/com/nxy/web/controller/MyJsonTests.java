package com.nxy.web.controller;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.json.*;
import org.springframework.boot.test.json.*;
import org.springframework.test.context.junit4.*;

import java.io.Serializable;

import static org.assertj.core.api.Assertions.*;
@JsonTest
public class MyJsonTests {
    @Autowired
    private JacksonTester<VehicleDetails> json ;

//    @Before
//    public void  setUp(){
//        this.json = new JacksonTester<VehicleDetails>()
//    }
    @Test
    public void testSerialize() throws Exception {
        VehicleDetails details = new VehicleDetails("Honda", "Civic");
        // Assert against a `.json` file in the same package as the test
        assertThat(this.json.write(details)).isEqualToJson("expected.json");
        // Or use JSON path based assertions
        assertThat(this.json.write(details)).hasJsonPathStringValue("@.make");
        assertThat(this.json.write(details)).extractingJsonPathStringValue("@.make")
                .isEqualTo("Honda");
    }

    @Test
    public void testDeserialize() throws Exception {
        String content = "{\"make\":\"Ford\",\"model\":\"Focus\"}";
        assertThat(this.json.parse(content))
                .isEqualTo(new VehicleDetails("Ford", "Focus"));
        assertThat(this.json.parseObject(content).getMake()).isEqualTo("Ford");
    }

    public class VehicleDetails implements Serializable {
        private static final long serialVersionUID = -3466902219500939310L;
        private String make;
        private String model;
        VehicleDetails(String make,String model){
            this.make = make;
            this.model= model;
        }
        public String getMake() {
            return make;
        }

        public void setMake(String make) {
            this.make = make;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }
    }

}