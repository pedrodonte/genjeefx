package util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

public class XmlUtil {

	@SuppressWarnings("rawtypes")
	public static String objectToXml(Object source, Class... type) {
		String result;
		StringWriter sw = new StringWriter();
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(type);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(source, sw);
			result = sw.toString();
		} catch (JAXBException e) {
			throw new RuntimeException(e);
		}

		return result;
	}
	
	public static void convertToXmlFile(File file, Object source, Class<?>... type) {
		System.out.println("Generando Archivo: "+file.getName());
		System.out.println("#############################");
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(type);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(source, file);
			marshaller.marshal(source, System.out);
		} catch (JAXBException e) {
			throw new RuntimeException(e);
		}
	}

	public static String extractValue(String xml, String xpathExpression) {
		String actual;
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
					.newInstance();
			documentBuilderFactory.setNamespaceAware(true);
			documentBuilderFactory.setIgnoringElementContentWhitespace(true);
			DocumentBuilder docBuilder = documentBuilderFactory
					.newDocumentBuilder();

			byte[] bytes = xml.getBytes("UTF-8");
			InputStream inputStream = new ByteArrayInputStream(bytes);
			Document doc = docBuilder.parse(inputStream);
			XPathFactory xPathFactory = XPathFactory.newInstance();
			XPath xpath = xPathFactory.newXPath();

			actual = xpath
					.evaluate(xpathExpression, doc, XPathConstants.STRING)
					.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return actual;
	}

	public static Object xmlToObject(String xml, Class<?>... type) {

		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(type);

			StringReader stringReader = new StringReader(xml);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			return jaxbUnmarshaller.unmarshal(stringReader);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static Object xmlFileToObject(File file, Class<?>... type) {

		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(type);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			return jaxbUnmarshaller.unmarshal(file);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return null;
	}

}
