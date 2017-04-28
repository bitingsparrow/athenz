//
// This file generated by rdl 1.4.12
//

package com.yahoo.athenz.instance.provider;
import com.yahoo.rdl.*;

public class InstanceProviderSchema {

    private final static Schema INSTANCE = build();
    public static Schema instance() {
        return INSTANCE;
    }

    private static Schema build() {
        SchemaBuilder sb = new SchemaBuilder("InstanceProvider");
        sb.version(1);
        sb.namespace("com.yahoo.athenz.instance.provider");
        sb.comment("Copyright 2017 Yahoo Inc. Licensed under the terms of the Apache version 2.0 license. See LICENSE file for terms. The Instance Provider API");

        sb.stringType("SimpleName")
            .comment("Copyright 2016 Yahoo Inc. Licensed under the terms of the Apache version 2.0 license. See LICENSE file for terms. Common name types used by several API definitions A simple identifier, an element of compound name.")
            .pattern("[a-zA-Z0-9_][a-zA-Z0-9_-]*");

        sb.stringType("CompoundName")
            .comment("A compound name. Most names in this API are compound names.")
            .pattern("([a-zA-Z0-9_][a-zA-Z0-9_-]*\\.)*[a-zA-Z0-9_][a-zA-Z0-9_-]*");

        sb.stringType("DomainName")
            .comment("A domain name is the general qualifier prefix, as its uniqueness is managed.")
            .pattern("([a-zA-Z0-9_][a-zA-Z0-9_-]*\\.)*[a-zA-Z0-9_][a-zA-Z0-9_-]*");

        sb.stringType("EntityName")
            .comment("An entity name is a short form of a resource name, including only the domain and entity.")
            .pattern("([a-zA-Z0-9_][a-zA-Z0-9_-]*\\.)*[a-zA-Z0-9_][a-zA-Z0-9_-]*");

        sb.stringType("ServiceName")
            .comment("A service name will generally be a unique subdomain.")
            .pattern("([a-zA-Z0-9_][a-zA-Z0-9_-]*\\.)*[a-zA-Z0-9_][a-zA-Z0-9_-]*");

        sb.stringType("ActionName")
            .comment("An action (operation) name.")
            .pattern("([a-zA-Z0-9_][a-zA-Z0-9_-]*\\.)*[a-zA-Z0-9_][a-zA-Z0-9_-]*");

        sb.stringType("ResourceName")
            .comment("A resource name Note that the EntityName part is optional, that is, a domain name followed by a colon is valid resource name.")
            .pattern("([a-zA-Z0-9_][a-zA-Z0-9_-]*\\.)*[a-zA-Z0-9_][a-zA-Z0-9_-]*(:([a-zA-Z0-9_][a-zA-Z0-9_-]*\\.)*[a-zA-Z0-9_][a-zA-Z0-9_-]*)?");

        sb.stringType("YBase64")
            .comment("The Y-specific URL-safe Base64 variant.")
            .pattern("[a-zA-Z0-9\\._-]+");

        sb.stringType("YEncoded")
            .comment("YEncoded includes ybase64 chars, as well as = and %. This can represent a user cookie and URL-encoded values.")
            .pattern("[a-zA-Z0-9\\._%=-]*");

        sb.stringType("AuthorityName")
            .comment("Used as the prefix in a signed assertion. This uniquely identifies a signing authority.")
            .pattern("([a-zA-Z0-9_][a-zA-Z0-9_-]*\\.)*[a-zA-Z0-9_][a-zA-Z0-9_-]*");

        sb.stringType("SignedToken")
            .comment("A signed assertion if identity. i.e. the user cookie value. This token will only make sense to the authority that generated it, so it is beneficial to have something in the value that is cheaply recognized to quickly reject if it belongs to another authority. In addition to the YEncoded set our token includes ; to separate components and , to separate roles")
            .pattern("[a-zA-Z0-9\\._%=;,-]*");

        sb.stringType("PathElement")
            .comment("A uri-safe path element")
            .pattern("[a-zA-Z0-9-._~=+@$,:]*");

        sb.structType("InstanceConfirmation")
            .field("provider", "ServiceName", false, "provider service name")
            .field("domain", "DomainName", false, "the domain of the instance")
            .field("service", "SimpleName", false, "the service this instance is supposed to run")
            .field("attestationData", "String", false, "identity attestation data including document with its signature containing attributes like IP address, instance-id, account#, etc.")
            .mapField("attributes", "String", "String", true, "additional non-signed attributes that assist in attestation. I.e. \"keyId\", \"accessKey\", etc");


        sb.resource("InstanceConfirmation", "POST", "/instance")
            .input("confirmation", "InstanceConfirmation", "")
            .auth("", "", true)
            .expected("OK")
            .exception("BAD_REQUEST", "ResourceError", "")

            .exception("FORBIDDEN", "ResourceError", "")

            .exception("UNAUTHORIZED", "ResourceError", "")
;


        return sb.build();
    }

}