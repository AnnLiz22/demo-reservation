package com.lietz.demo.model;

public enum ReservationStatus {
  PENDING("Pending"),
  CONFIRMED("Confirmed"),
  CANCELLED("Cancelled");

  private final String displayName;
  ReservationStatus(String displayName) {
    this.displayName = displayName;
  }
}
