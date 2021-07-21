package org.training.juneau;

import org.apache.juneau.html.HtmlSerializer;
import org.apache.juneau.json.JsonParser;
import org.apache.juneau.json.JsonSerializer;
import org.apache.juneau.parser.ParseException;
import org.apache.juneau.serializer.SerializeException;
import org.apache.juneau.xml.XmlSerializer;

public class DetailsTest {

	public static void main(String[] args) throws SerializeException, ParseException {

		// Serialization
		// POJO to JSON

		JsonSerializer jsonSerializer = JsonSerializer.DEFAULT_READABLE;

		String skills[] = { "Selenium", "Core java", "TestNG" };
		Details details = new Details("Anusha", 20, "Hyderabad", skills);

		String json = jsonSerializer.serialize(details);
		System.out.println(json);

		// POJO to XML

		XmlSerializer xmlSerializer = XmlSerializer.DEFAULT_NS_SQ_READABLE;

		String xml = xmlSerializer.serialize(details);

		System.out.println(xml);

		// POJO to HTML

		HtmlSerializer htmlSerializer = HtmlSerializer.DEFAULT_SQ_READABLE;

		String html = htmlSerializer.serialize(details);

		System.out.println(html);

		// Deserialization

		// Json to POJO

		JsonParser jsonParser = JsonParser.DEFAULT;

		String jsonval = "{\r\n" + "	\"address\": \"Hyderabad\",\r\n" + "	\"age\": 20,\r\n"
				+ "	\"name\": \"Anusha\",\r\n" + "	\"skills\": [\r\n" + "		\"Selenium\",\r\n"
				+ "		\"Core java\",\r\n" + "		\"TestNG\"\r\n" + "	]\r\n" + "}";

		Details det = jsonParser.parse(jsonval, Details.class);
		System.out.println(det.getName());
		System.out.println(det);
	}

}
