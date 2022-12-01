package com.bcnc.testreactive;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest
@AutoConfigureWebTestClient
class End2EndPriceTest {

	@Autowired
	WebTestClient webTestClient;

	@Test
	void shouldReturnTheRightPrice_Test1() {
		webTestClient.get()
				.uri("/brand/1/product/35455/appDate/2020-06-14T10:00:00.000Z")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isOk()
				.expectBody(String.class)
				.isEqualTo("{\"brandId\":1,\"startDate\":\"2020-06-14T00:00:00Z\",\"endDate\":\"2020-12-31T23:59:59Z\",\"priceList\":1,\"productId\":35455,\"price\":35.50}");
	}

	@Test
	void shouldReturnTheRightPrice_Test2()  {
		webTestClient.get()
				.uri("/brand/1/product/35455/appDate/2020-06-14T16:00:00.000Z")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isOk()
				.expectBody(String.class)
				.isEqualTo("{\"brandId\":1,\"startDate\":\"2020-06-14T15:00:00Z\",\"endDate\":\"2020-06-14T18:30:00Z\",\"priceList\":2,\"productId\":35455,\"price\":25.45}");
	}

	@Test
	void shouldReturnTheRightPrice_Test3() {
		webTestClient.get()
				.uri("/brand/1/product/35455/appDate/2020-06-14T21:00:00.000Z")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isOk()
				.expectBody(String.class)
				.isEqualTo("{\"brandId\":1,\"startDate\":\"2020-06-14T00:00:00Z\",\"endDate\":\"2020-12-31T23:59:59Z\",\"priceList\":1,\"productId\":35455,\"price\":35.50}");
	}

	@Test
	void shouldReturnTheRightPrice_Test4()  {
		webTestClient.get()
				.uri("/brand/1/product/35455/appDate/2020-06-15T10:00:00.000Z")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isOk()
				.expectBody(String.class)
				.isEqualTo("{\"brandId\":1,\"startDate\":\"2020-06-15T00:00:00Z\",\"endDate\":\"2020-06-15T11:00:00Z\",\"priceList\":3,\"productId\":35455,\"price\":30.50}");
	}

	@Test
	void shouldReturnTheRightPrice_Test5()  {
		webTestClient.get()
				.uri("/brand/1/product/35455/appDate/2020-06-16T21:00:00.000Z")
		.accept(MediaType.APPLICATION_JSON)
		.exchange()
		.expectStatus().isOk()
		.expectBody(String.class)
				.isEqualTo("{\"brandId\":1,\"startDate\":\"2020-06-15T16:00:00Z\",\"endDate\":\"2020-12-31T23:59:59Z\",\"priceList\":4,\"productId\":35455,\"price\":38.95}");
	}

	@Test
	void shouldReturnNullPrice_WhenDateOutOfRange() {
		webTestClient.get()
				.uri("/brand/1/product/35455/appDate/2022-06-16T21:00:00.000Z")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isOk()
				.expectBody(String.class)
				.isEqualTo("{\"brandId\":0,\"startDate\":null,\"endDate\":null,\"priceList\":0,\"productId\":0,\"price\":null}");
	}
	@Test
	void shouldReturnNullPrice_WhenNoProductId() {
		webTestClient.get()
				.uri("/brand/1/product/3545567/appDate/2020-06-16T21:00:00.000Z")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isOk()
				.expectBody(String.class)
				.isEqualTo("{\"brandId\":0,\"startDate\":null,\"endDate\":null,\"priceList\":0,\"productId\":0,\"price\":null}");
	}
	@Test
	void shouldReturnNullPrice_WhenNoBrandId() {
		webTestClient.get()
				.uri("/brand/200/product/35455/appDate/2020-06-16T21:00:00.000Z")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isOk()
				.expectBody(String.class)
				.isEqualTo("{\"brandId\":0,\"startDate\":null,\"endDate\":null,\"priceList\":0,\"productId\":0,\"price\":null}");
	}
	@Test
	void shouldReturnNotFound_WhenMalformedURL() {
		webTestClient.get()
				.uri("/brand/200/prodct/35455/appDate/2020-06-16T21:00:00.000Z")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isNotFound();
	}
	@Test
	void shouldReturn5xx_WhenMalformedDate() {
		webTestClient.get()
				.uri("/brand/1/product/35455/appDate/2020-06-1")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().is5xxServerError();
	}
}
