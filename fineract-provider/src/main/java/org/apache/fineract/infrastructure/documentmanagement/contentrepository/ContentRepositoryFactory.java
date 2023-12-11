/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.fineract.infrastructure.documentmanagement.contentrepository;

<<<<<<< HEAD
import lombok.RequiredArgsConstructor;
import org.apache.fineract.infrastructure.configuration.data.S3CredentialsData;
import org.apache.fineract.infrastructure.configuration.domain.ConfigurationDomainService;
import org.apache.fineract.infrastructure.configuration.service.ExternalServicesPropertiesReadPlatformService;
import org.apache.fineract.infrastructure.documentmanagement.domain.StorageType;
import org.springframework.context.ApplicationContext;
=======
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.fineract.infrastructure.core.config.FineractProperties;
import org.apache.fineract.infrastructure.documentmanagement.domain.StorageType;
>>>>>>> develop
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ContentRepositoryFactory {

<<<<<<< HEAD
    private final ApplicationContext applicationContext;
    private final ExternalServicesPropertiesReadPlatformService externalServicesReadPlatformService;

    private final FileSystemContentPathSanitizer contentPathSanitizer;
=======
    private final FineractProperties fineractProperties;
    private final List<ContentRepository> contentRepositories;
>>>>>>> develop

    public ContentRepository getRepository() {
        if (fineractProperties.getContent() != null) {
            if (fineractProperties.getContent().getFilesystem() != null
                    && Boolean.TRUE.equals(fineractProperties.getContent().getFilesystem().getEnabled())) {
                return getRepository(StorageType.FILE_SYSTEM);
            } else if (fineractProperties.getContent().getS3() != null
                    && Boolean.TRUE.equals(fineractProperties.getContent().getS3().getEnabled())) {
                return getRepository(StorageType.S3);
            }
        }
<<<<<<< HEAD
        return new FileSystemContentRepository(contentPathSanitizer);
    }

    public ContentRepository getRepository(final StorageType documentStoreType) {
        if (documentStoreType == StorageType.FILE_SYSTEM) {
            return new FileSystemContentRepository(contentPathSanitizer);
        }
        return createS3DocumentStore();
=======

        throw new RuntimeException(
                "No content repository enabled. Please set either 'fineract.content.filesystem.enabled=true' or 'fineract.content.s3.enabled=true' in your application.properties.");
>>>>>>> develop
    }

    public ContentRepository getRepository(StorageType storageType) {
        return contentRepositories.stream().filter(cr -> cr.getStorageType().equals(storageType)).findFirst().orElseThrow(
                () -> new RuntimeException(String.format("No content repository implementation found for storage type: %s", storageType)));
    }
}
