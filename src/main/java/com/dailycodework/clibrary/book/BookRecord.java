package com.dailycodework.clibrary.book;

import java.util.UUID;

public record BookRecord(String title, String author, String edition, UUID ISBN) {
}
