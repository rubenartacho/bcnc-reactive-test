package com.bcnc.testreactive;

import com.bcnc.testreactive.controllers.dto.entities.PriceDTO;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.util.Assert;

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
				.expectBody()
				.jsonPath("brandId").isEqualTo(1)
				.jsonPath("priceList").isEqualTo(1)
				.jsonPath("productId").isEqualTo(35455)
				.jsonPath("price").isEqualTo(35.50)
				.jsonPath("currency").isEqualTo("EUR")
				.jsonPath("startDate").isEqualTo("2020-06-14T00:00:00Z")
				.jsonPath("endDate").isEqualTo("2020-12-31T23:59:59Z");

}

	@Test
	void shouldReturnTheRightPrice_Test2()  {
		webTestClient.get()
				.uri("/brand/1/product/35455/appDate/2020-06-14T16:00:00.000Z")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("brandId").isEqualTo(1)
				.jsonPath("priceList").isEqualTo(2)
				.jsonPath("productId").isEqualTo(35455)
				.jsonPath("price").isEqualTo(25.45)
				.jsonPath("currency").isEqualTo("EUR")
				.jsonPath("startDate").isEqualTo("2020-06-14T15:00:00Z")
				.jsonPath("endDate").isEqualTo("2020-06-14T18:30:00Z");
}

	@Test
	void shouldReturnTheRightPrice_Test3() {
		webTestClient.get()
				.uri("/brand/1/product/35455/appDate/2020-06-14T21:00:00.000Z")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("brandId").isEqualTo(1)
				.jsonPath("priceList").isEqualTo(1)
				.jsonPath("productId").isEqualTo(35455)
				.jsonPath("price").isEqualTo(35.50)
				.jsonPath("currency").isEqualTo("EUR")
				.jsonPath("startDate").isEqualTo("2020-06-14T00:00:00Z")
				.jsonPath("endDate").isEqualTo("2020-12-31T23:59:59Z");
}

	@Test
	void shouldReturnTheRightPrice_Test4()  {
		webTestClient.get()
				.uri("/brand/1/product/35455/appDate/2020-06-15T10:00:00.000Z")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("brandId").isEqualTo(1)
				.jsonPath("priceList").isEqualTo(3)
				.jsonPath("productId").isEqualTo(35455)
				.jsonPath("price").isEqualTo(30.50)
				.jsonPath("currency").isEqualTo("EUR")
				.jsonPath("startDate").isEqualTo("2020-06-15T00:00:00Z")
				.jsonPath("endDate").isEqualTo("2020-06-15T11:00:00Z");
}

	@Test
	void shouldReturnTheRightPrice_Test5()  {
		webTestClient.get()
				.uri("/brand/1/product/35455/appDate/2020-06-16T21:00:00.000Z")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("brandId").isEqualTo(1)
				.jsonPath("priceList").isEqualTo(4)
				.jsonPath("productId").isEqualTo(35455)
				.jsonPath("price").isEqualTo(38.95)
				.jsonPath("currency").isEqualTo("EUR")
				.jsonPath("startDate").isEqualTo("2020-06-15T16:00:00Z")
				.jsonPath("endDate").isEqualTo("2020-12-31T23:59:59Z");

}

	@Test
	void shouldReturnNullPrice_WhenDateOutOfRange() {
		webTestClient.get()
				.uri("/brand/1/product/35455/appDate/2022-06-16T21:00:00.000Z")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("brandId").isEqualTo(0)
				.jsonPath("priceList").isEqualTo(0)
				.jsonPath("productId").isEqualTo(0)
				.jsonPath("price").isEqualTo(null)
				.jsonPath("currency").isEqualTo(null)
				.jsonPath("startDate").isEqualTo(null)
				.jsonPath("endDate").isEqualTo(null);
	}
	@Test
	void shouldReturnNullPrice_WhenNoProductId() {
		webTestClient.get()
				.uri("/brand/1/product/3545567/appDate/2020-06-16T21:00:00.000Z")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("brandId").isEqualTo(0)
				.jsonPath("priceList").isEqualTo(0)
				.jsonPath("productId").isEqualTo(0)
				.jsonPath("price").isEqualTo(null)
				.jsonPath("currency").isEqualTo(null)
				.jsonPath("startDate").isEqualTo(null)
				.jsonPath("endDate").isEqualTo(null);
	}
	@Test
	void shouldReturnNullPrice_WhenNoBrandId() {
		webTestClient.get()
				.uri("/brand/200/product/35455/appDate/2020-06-16T21:00:00.000Z")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("brandId").isEqualTo(0)
				.jsonPath("priceList").isEqualTo(0)
				.jsonPath("productId").isEqualTo(0)
				.jsonPath("price").isEqualTo(null)
				.jsonPath("currency").isEqualTo(null)
				.jsonPath("startDate").isEqualTo(null)
				.jsonPath("endDate").isEqualTo(null);
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
