package com.bcnc.testreactive.controllers.utils;

/**
 * This is used for controlling which fields are serialized in each JSON mapping.
 * So we can hide some fields in some controller methods.
 */
public class View {
    public static class Public { }
    public static class Detailed extends Public{}
    public static class ExtendedPublic extends Detailed{ }
    public static class Internal extends ExtendedPublic { }
}
