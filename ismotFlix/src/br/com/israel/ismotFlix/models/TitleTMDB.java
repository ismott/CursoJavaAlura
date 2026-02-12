package br.com.israel.ismotFlix.models;

import java.util.List;

public record TitleTMDB(int page, List<Results> results) {
}
