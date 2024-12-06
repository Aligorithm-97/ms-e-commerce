package com.aligorithm.ecommerce.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(
         String id,
         @NotNull(message = "Firstname required !")
         String firstname,
         @NotNull(message = "Lastname required !")
         String lastname,
         @NotNull(message = "Email required !")
         @Email(message = "Not valid !")
         String email,
         Address address
) {
}
