/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2016 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *
 *
 */
angular.module('backendMocks', ['ngMockE2E', 'functionsModule', 'resourceLocationsModule', 'languageServiceModule'])
    .constant('URL_FOR_ITEM', /cmswebservices\/v1\/catalogs\/electronics\/versions\/staged\/items\/thesmarteditComponentId/)
    .run(function($httpBackend, filterFilter, parseQuery, URL_FOR_ITEM, I18N_RESOURCE_URI, languageService) {

        var payload_headline_2_invalid = {
            active: true,
            content: {
                'type': 'map',
                'value': {
                    'en': 'the content to edit',
                    "fr": "le contenu a editer",
                    'pl': 'tresc edytowac',
                    'it': 'il contenuto da modificare',
                    'hi': 'Sampaadit karanee kee liee saamagree'
                }
            },
            media: {
                'type': 'map',
                'value': {
                    'en': 'clone4'
                }
            },
            external: false,
            headline: "I have changed to an invalid headline with two validation errors, % and lots of text",
            id: "thesmarteditComponentId",
            identifier: "thesmarteditComponentId",
        };

        var payload_headline_1_invalid = {
            active: true,
            content: {
                'type': 'map',
                'value': {
                    'en': 'the content to edit',
                    "fr": "le contenu a editer",
                    'pl': 'tresc edytowac',
                    'it': 'il contenuto da modificare',
                    'hi': 'Sampaadit karanee kee liee saamagree'
                }
            },
            media: {
                'type': 'map',
                'value': {
                    'en': 'clone4'
                }
            },
            external: false,
            headline: "I have changed to an invalid headline with one validation error, %",
            id: "thesmarteditComponentId",
            identifier: "thesmarteditComponentId"
        };

        var payload_all_valid = {
            active: true,
            content: {
                'type': 'map',
                'value': {
                    'en': 'the content to edit',
                    "fr": "le contenu a editer",
                    'pl': 'tresc edytowac',
                    'it': 'il contenuto da modificare',
                    'hi': 'Sampaadit karanee kee liee saamagree'
                }
            },
            media: {
                'type': 'map',
                'value': {
                    'en': 'clone4'
                }
            },
            external: false,
            headline: "I have no errors",
            id: "thesmarteditComponentId",
            identifier: "thesmarteditComponentId"
        };

        var payload_content_invalid = {
            active: true,
            content: {
                'type': 'map',
                'value': {
                    'en': 'I have changed to an invalid content with one validation error',
                    "fr": "le contenu a editer",
                    'pl': 'tresc edytowac',
                    'it': 'Ho cambiato ad un contenuto non valido con un errore di validazione',
                    'hi': 'Sampaadit karanee kee liee saamagree'
                }
            },
            media: {
                'type': 'map',
                'value': {
                    'en': 'clone4'
                }
            },
            external: false,
            headline: "The Headline",
            id: "thesmarteditComponentId",
            identifier: "thesmarteditComponentId"
        };


        var payload_without_image = {
            active: true,
            content: {
                'type': 'map',
                'value': {
                    'en': 'the content to edit',
                    "fr": "le contenu a editer",
                    'pl': 'tresc edytowac',
                    'it': 'il contenuto da modificare',
                    'hi': 'Sampaadit karanee kee liee saamagree'
                }
            },
            media: {
                'type': 'map',
                'value': {}
            },
            external: false,
            headline: "The Headline",
            id: "thesmarteditComponentId",
            identifier: "thesmarteditComponentId"
        };

        var payload_for_unknown_type = {
            active: true,
            content: {
                'type': 'map',
                'value': {
                    'en': 'I have changed to an invalid content with one validation error',
                    "fr": "le contenu a editer",
                    'pl': 'tresc edytowac',
                    'it': 'Ho cambiato ad un contenuto non valido con un errore di validazione',
                    'hi': 'Sampaadit karanee kee liee saamagree'
                }
            },
            media: {
                'type': 'map',
                'value': {
                    'en': 'clone4'
                }
            },
            external: false,
            headline: "Checking unknown type",
            id: "thesmarteditComponentId",
            identifier: "thesmarteditComponentId"
        };

        var payload_with_two_media_selected = {
            active: true,
            content: {
                'type': 'map',
                'value': {
                    'en': 'the content to edit',
                    "fr": "le contenu a editer",
                    'pl': 'tresc edytowac',
                    'it': 'il contenuto da modificare',
                    'hi': 'Sampaadit karanee kee liee saamagree'
                }
            },
            media: {
                'type': 'map',
                'value': {
                    'en': 'clone4',
                    'fr': 'trash3'
                }
            },
            external: false,
            headline: "The Headline",
            id: "thesmarteditComponentId",
            identifier: "thesmarteditComponentId"
        };

        $httpBackend.whenPUT(URL_FOR_ITEM, payload_headline_2_invalid).respond(function(method, url, data, headers) {
            return [400, validationErrors_Headline];
        });

        $httpBackend.whenPUT(URL_FOR_ITEM, payload_content_invalid).respond(function(method, url, data, headers) {
            return [400, validationErrors_content_2tab];
        });

        $httpBackend.whenPUT(URL_FOR_ITEM, payload_headline_1_invalid).respond(function(method, url, data, headers) {
            return [400, validationErrors_1];
        });

        $httpBackend.whenPUT(URL_FOR_ITEM, payload_without_image).respond(function(method, url, data, headers) {
            return [400, validationErrors_No_Media];
        });

        $httpBackend.whenPUT(URL_FOR_ITEM, payload_for_unknown_type).respond(function(method, url, data, headers) {
            return [400, validationErrors_Unknown_Type];
        });

        $httpBackend.whenPUT(URL_FOR_ITEM, payload_all_valid).respond(function(method, url, data, headers) {
            return [400, validationErrors_1];
        });

        $httpBackend.whenPUT(URL_FOR_ITEM, payload_with_two_media_selected).respond(function(method, url, data, headers) {
            return [200];
        });

        var validationErrors_Headline = {
            "errors": [{
                "message": "This field is required and must to be between 1 and 255 characters long.",
                "reason": "missing",
                "subject": "headline",
                "subjectType": "parameter",
                "type": "ValidationError"
            }, {
                "message": "This field cannot contain special characters",
                "reason": "missing",
                "subject": "headline",
                "subjectType": "parameter",
                "type": "ValidationError"
            }]
        };

        var validationErrors_content_2tab = {
            "errors": [{
                "message": "This field is required and must to be between 1 and 255 characters long. Language: [en]",
                "reason": "missing",
                "subject": "content",
                "subjectType": "parameter",
                "type": "ValidationError"
            }, {
                "message": "This field is required and must to be between 1 and 255 characters long. Language: [it]",
                "reason": "missing",
                "subject": "content",
                "subjectType": "parameter",
                "type": "ValidationError"
            }]
        };

        var validationErrors_2 = {
            "errors": [{
                "message": "This field cannot contain special characters",
                "reason": "missing",
                "subject": "headline",
                "subjectType": "parameter",
                "type": "ValidationError"
            }, {
                "message": "This field is required and must to be between 1 and 255 characters long.",
                "reason": "missing",
                "subject": "content",
                "subjectType": "parameter",
                "type": "ValidationError"
            }]
        };

        var validationErrors_1 = {
            "errors": [{
                "message": "This field is required and must to be between 1 and 255 characters long.",
                "reason": "missing",
                "subject": "headline",
                "subjectType": "parameter",
                "type": "ValidationError"
            }]
        };

        var validationErrors_No_Media = {
            "errors": [{
                "message": "A Media must be selected. Language: [en]",
                "reason": "missing",
                "subject": "media",
                "subjectType": "parameter",
                "type": "ValidationError"
            }, {
                "message": "A Media must be selected. Language: [fr]",
                "reason": "missing",
                "subject": "media",
                "subjectType": "parameter",
                "type": "ValidationError"
            }]
        };

        var validationErrors_Unknown_Type = {
            "errors": [{
                "message": "The type is not valid",
                "reason": "missing",
                "subject": "unknownType",
                "subjectType": "parameter",
                "type": "ValidationError"
            }]
        };

        $httpBackend.whenGET(I18N_RESOURCE_URI + "/" + languageService.getBrowserLocale()).respond({
            "genericeditor.dropdown.placeholder": "Search...",
            "componentform.actions.cancel": "Cancel",
            "componentform.actions.submit": "Submit",
            "componentform.actions.replaceImage": "Replace Image",
            "type.thesmarteditComponentType.id.name": "id",
            "type.thesmarteditComponentType.headline.name": "Headline",
            "type.thesmarteditComponentType.active.name": "Activation",
            "type.thesmarteditComponentType.content.name": "Content",
            "type.thesmarteditComponentType.create.name": "Creation date",
            "type.thesmarteditComponentType.media.name": "Media",
            "type.thesmarteditComponentType.external.name": "External Link",
            "type.thesmarteditComponentType.urlLink.name": "Url Link",
            "editor.linkTo.label": "Link to",
            "editor.linkTo.external.label": "External Link",
            "editor.linkTo.internal.label": "Existing Page"
        });

        $httpBackend.whenGET(/cmswebservices\/v1\/types\/thesmarteditComponentType/).respond(function(method, url, data, headers) {
            var structure = {
                attributes: [{
                    cmsStructureType: "ShortString",
                    qualifier: "id",
                    i18nKey: 'type.thesmarteditComponentType.id.name',
                    localized: false
                }, {
                    cmsStructureType: "Media",
                    qualifier: "media",
                    i18nKey: 'type.thesmarteditComponentType.media.name',
                    localized: true
                }, {
                    cmsStructureType: "LongString",
                    qualifier: "headline",
                    i18nKey: 'type.thesmarteditComponentType.headline.name',
                    localized: false
                }, {
                    cmsStructureType: "Boolean",
                    qualifier: "active",
                    i18nKey: 'type.thesmarteditComponentType.active.name',
                    localized: false
                }, {
                    cmsStructureType: "RichText",
                    qualifier: "content",
                    i18nKey: 'type.thesmarteditComponentType.content.name',
                    localized: true
                }, {
                    cmsStructureType: "ShortString",
                    qualifier: "urlLink",
                    i18nKey: 'type.thesmarteditComponentType.urlLink.name',
                    localized: false
                }]
            };

            return [200, structure];
        });

        var component = {

            id: 'thesmarteditComponentId',
            headline: 'The Headline',
            active: true,
            content: {
                'type': 'map',
                'value': {
                    'en': 'the content to edit',
                    'fr': 'le contenu a editer',
                    'pl': 'tresc edytowac',
                    'it': 'il contenuto da modificare',
                    'hi': 'Sampaadit karanee kee liee saamagree'
                }
            },
            media: {
                'type': 'map',
                'value': {
                    'en': 'clone4'
                }
            },
            external: false
        };

        $httpBackend.whenGET(/cmswebservices\/v1\/sites\/.*\/languages/).respond({
            languages: [{
                nativeName: 'English',
                isocode: 'en',
                required: true
            }, {
                nativeName: 'French',
                isocode: 'fr',
                required: true
            }, {
                nativeName: 'Italian',
                isocode: 'it'
            }, {
                nativeName: 'Polish',
                isocode: 'pl'
            }, {
                nativeName: 'Hindi',
                isocode: 'hi'
            }]
        });

        $httpBackend.whenGET(URL_FOR_ITEM).respond(component);

        var medias = [{
            id: '1',
            code: 'pencil1',
            description: 'My blue pencil',
            altText: 'pencil alttext',
            realFileName: 'edit_bckg.png',
            url: 'web/webroot/icons/edit_bckg.png'
        }, {
            id: '2',
            code: 'more2',
            description: 'More background',
            altText: 'more alttext',
            realFileName: 'more_bckg.png',
            url: 'web/webroot/icons/more_bckg.png'
        }, {
            id: '3',
            code: 'trash3',
            description: 'Trash background',
            altText: 'trash alttext',
            realFileName: 'trash_bckg.png',
            url: 'web/webroot/icons/trash_bckg.png'
        }, {
            id: '4',
            code: 'clone4',
            description: 'Clone background',
            altText: 'clone alttext',
            realFileName: 'clone_bckg.png',
            url: 'web/webroot/icons/clone_bckg.png'
        }, {
            id: '5',
            code: 'dnd5',
            description: 'Drag and drop background',
            altText: 'dnd alttext',
            realFileName: 'dnd_bckg.png',
            url: 'web/webroot/icons/dnd_bckg.png'
        }, {
            id: '6',
            code: 'roll6',
            description: 'Rollback background',
            altText: 'rollback alttext',
            realFileName: 'rollback_bckg.png',
            url: 'web/webroot/icons/rollback_bckg.png'
        }];

        $httpBackend.whenGET(/cmswebservices\/v1\/catalogs\/electronics\/versions\/staged\/media\/(.+)/).respond(function(method, url, data, headers) {
            var identifier = /media\/(.+)/.exec(url)[1];
            console.info("get media", identifier);
            var filtered = medias.filter(function(media) {
                return media.code == identifier;
            });
            if (filtered.length == 1) {
                return [200, filtered[0]];
            } else {
                return [404];
            }
        });

        $httpBackend.whenGET(/cmswebservices\/v1\/media/).respond(function(method, url, data, headers) {
            console.info("query medias");
            var params = parseQuery(url).params;
            var search = params.split(",")[0].split(":").pop();
            var filtered = filterFilter(medias, search);
            return [200, {
                media: filtered
            }];
        });

        var options = [{
            pk: "8796106358834",
            medias: [{
                pk: "8796302508062",
                altText: "Sharp and brilliant images",
                url: "/medias/Elec-200x150-HomeFam-EN-01-200W.jpg?context=bWFzdGVyfGltYWdlc3wzNDgyM3xpbWFnZS9qcGVnfGltYWdlcy9oYWQvaDM4Lzg3OTYzMDI1NDA4MzAuanBnfDhmZmQwODQzZmNiNjQyYmEyM2U4NTA2OWI4MGVkZTEyNGJjNzNlNzAwYjVmZDA5OTE3Y2YyYzM4OWNmMTljYWY"
            }, {
                pk: "8796302573598",
                altText: "Sharp and brilliant images",
                url: "/medias/Elec-240x180-HomeFam-EN-01-240W.jpg?context=bWFzdGVyfGltYWdlc3w0NTI4NnxpbWFnZS9qcGVnfGltYWdlcy9oYzgvaDE5Lzg3OTYzMDI2MDYzNjYuanBnfDhiYTVhYjZiMmQwYjFkZDcwY2E4OTg5MzBhOTZjMDVlY2M1ZDNhMGFlMmUwYzNhYjU4NjM1ZmU1YTI5NTI0NDY"
            }, {
                pk: "8796302639134",
                altText: "Sharp and brilliant images",
                url: "/medias/Elec-350x262-HomeFam-EN-01-350W.jpg?context=bWFzdGVyfGltYWdlc3w3OTg4NnxpbWFnZS9qcGVnfGltYWdlcy9oMDkvaDU5Lzg3OTYzMDI2NzE5MDIuanBnfGIxNWQyYzc2NjQ2ODhiMjFlYmUyODA3NzZhMTIwNWZkYWQ1MWUyZmNlNjUxM2I0YzM3MGY1Y2Y1MTBjNmRiNzg"
            }]
        }, {
            pk: "8796106326066",
            medias: [{
                pk: "8796302245918",
                altText: "25 % Off ALL DIGITAL CAMERAS",
                url: "/medias/Elec-480x118-HomeDiscount-EN-01-480W.jpg?context=bWFzdGVyfGltYWdlc3wxOTg0N3xpbWFnZS9qcGVnfGltYWdlcy9oOTgvaGJjLzg3OTYzMDIyNzg2ODYuanBnfGE3MTQ5Y2RhOGQ2MDkyODg1NWQ2OWVhZjVmZjA3YTViMTg3ZmEwZGJjNzNiMGQ1MjJlZjllOTdlYTFmYTRiNjQ"
            }, {
                pk: "8796302311454",
                altText: "25 % Off ALL DIGITAL CAMERAS",
                url: "/medias/Elec-770x80-HomeDiscount-EN-01-770W.jpg?context=bWFzdGVyfGltYWdlc3wyMDMzMXxpbWFnZS9qcGVnfGltYWdlcy9oMzkvaGI3Lzg3OTYzMDIzNDQyMjIuanBnfDI0NjFlYzRkNmI1MzkyNjFjMDJhZmNlNmNlZjU4MmUyZTJkZTYzZWU1ZmQwZDhlMDk1ZGI4NzgxNjFiNTI2ZWM"
            }, {
                pk: "8796302376990",
                altText: "25 % Off ALL DIGITAL CAMERAS",
                url: "/medias/Elec-960x80-HomeDiscount-EN-01-960W.jpg?context=bWFzdGVyfGltYWdlc3wxOTk1MHxpbWFnZS9qcGVnfGltYWdlcy9oNTkvaDI4Lzg3OTYzMDI0MDk3NTguanBnfGU0OTdkNzY1NjYxNjVkM2M0YTRiM2JmZGI0ZTVmNGQzYjI4YTg1ZjM0YmMyM2FiMGRiZDhlYzU3ZTJhODZiNDE"
            }, {
                pk: "8796302442526",
                altText: "25 % Off ALL DIGITAL CAMERAS",
                url: "/medias/Elec-1400x80-HomeDiscount-EN-01-1400W.jpg?context=bWFzdGVyfGltYWdlc3wyMTMyNnxpbWFnZS9qcGVnfGltYWdlcy9oYmEvaGZlLzg3OTYzMDI0NzUyOTQuanBnfDA0NmUzOGQzZmNjY2U4ZmEwNjZlNTlkYWFkNDYyMjY0NGJlYjcxNDA1ZmJlYTA4MGQxZDcxYmU3ODY3ZDdmZjc"
            }]
        }, {
            pk: "8796106293298",
            medias: [{
                altText: "Fast Precise",
                pk: "8796301983774",
                url: "/medias/Elec-480x320-HomeSpeed-EN-01-480W.jpg?context=bWFzdGVyfGltYWdlc3wxMjc4NzN8aW1hZ2UvanBlZ3xpbWFnZXMvaGEzL2g2Ny84Nzk2MzAyMDE2NTQyLmpwZ3w2ZDY4ZGRjNjI5Mjk3ZDY3ZjJlYzkzNjQwZWZmYWJjMjk2YjdhNTJmMTgxZDU2OGE0YzBlMTM1ZmRmM2VmYjkx"
            }, {
                altText: "Fast Precise",
                pk: "8796302049310",
                url: "/medias/Elec-770x350-HomeSpeed-EN-01-770W.jpg?context=bWFzdGVyfGltYWdlc3wxOTMxMzZ8aW1hZ2UvanBlZ3xpbWFnZXMvaGJmL2hjMS84Nzk2MzAyMDgyMDc4LmpwZ3w1ZWQ1YTcyNDg0Y2E5ZjFlZWY3MzM4NTVhYzUzODgyMmU0YWU0MTVjMGQ1MjY3OTQ1Y2I0NzdkYTJkMDdjZmY3"
            }, {
                altText: "Fast Precise",
                pk: "8796302114846",
                url: "/medias/Elec-960x330-HomeSpeed-EN-01-960W.jpg?context=bWFzdGVyfGltYWdlc3wyMDM3MzN8aW1hZ2UvanBlZ3xpbWFnZXMvaDViL2hmOS84Nzk2MzAyMTQ3NjE0LmpwZ3wzMWY4NWE4MzIwNTQ5MTdkZTYwODNkMGYxYTc4NjAyZTE0YjczYjBlMTUzMmY1NGI2NWFhZDg5YmIxNmZhZTlk"
            }, {
                altText: "Fast Precise",
                pk: "8796302180382",
                url: "/medias/Elec-1400x440-HomeSpeed-EN-01-1400W.jpg?context=bWFzdGVyfGltYWdlc3wzNTc4OTR8aW1hZ2UvanBlZ3xpbWFnZXMvaDgyL2gyNS84Nzk2MzAyMjEzMTUwLmpwZ3w2MDViNDY0MDhkM2Y3ZDY3MGYzNmM4OGQ5NTM3Mzk3NGNkNmFjM2Y4ZjA2ZDU0ZDhjOWFhOGJmN2I3MmFhMGQ0"
            }]
        }];


        $httpBackend.whenGET(/cmsxdata\/contentcatalog\/staged\/MediaContainerDTO/).respond(function(method, url, data, headers) {
            console.info("querying MediaContainerDTO : ", url);
            return [200, filterFilter(options, parseQuery(url).search)];
        });

        $httpBackend.whenGET(/i18n/).passThrough();
        $httpBackend.whenGET(/cmsxstructure/).passThrough();
        $httpBackend.whenGET(/cmsxdata/).passThrough();
        $httpBackend.whenPOST(/cmsxdata/).passThrough();
        $httpBackend.whenPUT(/cmsxdata/).passThrough();
        $httpBackend.whenDELETE(/cmsxdata/).passThrough();
        $httpBackend.whenGET(/view/).passThrough(); //calls to storefront render API
        $httpBackend.whenPUT(/contentslots/).passThrough();
        $httpBackend.whenGET(/\.html/).passThrough();

    });
angular.module('genericEditorApp').requires.push('backendMocks');
