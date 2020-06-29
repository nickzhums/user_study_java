package org.example;

import com.azure.core.credential.TokenCredential;
import com.azure.core.management.AzureEnvironment;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.resourcemanager.Azure;
import com.azure.resourcemanager.resources.fluentcore.profile.AzureProfile;
import com.azure.resourcemanager.resources.models.ResourceGroup;

import java.util.List;

public class TrackTwo {

    public TrackTwo() {
        // no op constructor
    }

    public void createResources() {
        AzureProfile profile = new AzureProfile(AzureEnvironment.AZURE);
        TokenCredential credential = new DefaultAzureCredentialBuilder().authorityHost(profile.environment().getActiveDirectoryEndpoint()).build();
        Azure azure = Azure.authenticate(credential, profile).withDefaultSubscription();
        for (ResourceGroup rg :  azure.resourceGroups().list()) {
            System.out.println("Resource group: " + rg.name());
        }


    }
}
