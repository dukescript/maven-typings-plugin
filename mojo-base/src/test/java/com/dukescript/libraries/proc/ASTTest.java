package com.dukescript.libraries.proc;

/*
 * #%L
 * DukeScript Libraries Processor - a library from the DukeScript project.
 * Visit http://dukescript.com for support and commercial license.
 * %%
 * Copyright (C) 2015 Eppleton IT Consulting
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

import java.io.ByteArrayInputStream;
import java.io.IOException;
import net.java.html.BrwsrCtx;
import net.java.html.json.Models;
import net.java.html.junit.BrowserRunner;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(BrowserRunner.class)
public class ASTTest {
    @Test
    public void substituteTypeVars() throws IOException {
        BrwsrCtx ctx = BrwsrCtx.findDefault(ASTTest.class);
        String type = ""
            + "{\n"
            + "    \"kind\": \"FunctionType\",\n"
            + "    \"typeName\": null,\n"
            + "    \"type\": [\n"
            + "        {\n"
            + "            \"kind\": \"FirstTypeNode\",\n"
            + "            \"typeName\": {\n"
            + "                \"text\": \"Array\"\n"
            + "            },\n"
            + "            \"type\": [\n"
            + "            ],\n"
            + "            \"types\": [\n"
            + "            ],\n"
            + "            \"typeArguments\": [\n"
            + "                {\n"
            + "                    \"kind\": \"FirstTypeNode\",\n"
            + "                    \"typeName\": {\n"
            + "                        \"text\": \"T\"\n"
            + "                    },\n"
            + "                    \"type\": [\n"
            + "                    ],\n"
            + "                    \"types\": [\n"
            + "                    ],\n"
            + "                    \"typeArguments\": [\n"
            + "                    ],\n"
            + "                    \"typeParameters\": [\n"
            + "                    ],\n"
            + "                    \"parameters\": [\n"
            + "                    ],\n"
            + "                    \"elementType\": [\n"
            + "                    ],\n"
            + "                    \"members\": [\n"
            + "                    ]\n"
            + "                }\n"
            + "            ],\n"
            + "            \"typeParameters\": [\n"
            + "            ],\n"
            + "            \"parameters\": [\n"
            + "            ],\n"
            + "            \"elementType\": [\n"
            + "            ],\n"
            + "            \"members\": [\n"
            + "            ]\n"
            + "        }\n"
            + "    ],\n"
            + "    \"types\": [\n"
            + "    ],\n"
            + "    \"typeArguments\": [\n"
            + "    ],\n"
            + "    \"typeParameters\": [\n"
            + "    ],\n"
            + "    \"parameters\": [\n"
            + "        {\n"
            + "            \"name\": {\n"
            + "                \"text\": \"arr\"\n"
            + "            },\n"
            + "            \"type\": {\n"
            + "                \"kind\": \"FirstTypeNode\",\n"
            + "                \"typeName\": {\n"
            + "                    \"text\": \"Array\"\n"
            + "                },\n"
            + "                \"type\": [\n"
            + "                ],\n"
            + "                \"types\": [\n"
            + "                ],\n"
            + "                \"typeArguments\": [\n"
            + "                    {\n"
            + "                        \"kind\": \"FirstTypeNode\",\n"
            + "                        \"typeName\": {\n"
            + "                            \"text\": \"T\"\n"
            + "                        },\n"
            + "                        \"type\": [\n"
            + "                        ],\n"
            + "                        \"types\": [\n"
            + "                        ],\n"
            + "                        \"typeArguments\": [\n"
            + "                        ],\n"
            + "                        \"typeParameters\": [\n"
            + "                        ],\n"
            + "                        \"parameters\": [\n"
            + "                        ],\n"
            + "                        \"elementType\": [\n"
            + "                        ],\n"
            + "                        \"members\": [\n"
            + "                        ]\n"
            + "                    }\n"
            + "                ],\n"
            + "                \"typeParameters\": [\n"
            + "                ],\n"
            + "                \"parameters\": [\n"
            + "                ],\n"
            + "                \"elementType\": [\n"
            + "                ],\n"
            + "                \"members\": [\n"
            + "                ]\n"
            + "            },\n"
            + "            \"questionToken\": null,\n"
            + "            \"dotDotDotToken\": null\n"
            + "        }\n"
            + "    ],\n"
            + "    \"elementType\": [\n"
            + "    ],\n"
            + "    \"members\": [\n"
            + "    ]\n"
            + "}";
        Type astType = Models.parse(ctx, Type.class, new ByteArrayInputStream(type.getBytes()));
        assertEquals("Type variable T is there", "T", astType.getType().get(0).getTypeArguments().get(0).getTypeName().getSimpleName());
        astType.anonimize();
        assertEquals("Type variable has been anonymized", "?", astType.getType().get(0).getTypeArguments().get(0).getTypeName().getSimpleName());
    }
    @Test
    public void substituteTypeVars2() throws IOException {
        BrwsrCtx ctx = BrwsrCtx.findDefault(ASTTest.class);
        String type = ""
            + "{\n" +
"    \"kind\": \"FunctionType\",\n" +
"    \"typeName\": null,\n" +
"    \"type\": [\n" +
"        {\n" +
"            \"kind\": \"UnionType\",\n" +
"            \"typeName\": null,\n" +
"            \"type\": [\n" +
"            ],\n" +
"            \"types\": [\n" +
"                {\n" +
"                    \"kind\": \"FirstTypeNode\",\n" +
"                    \"typeName\": {\n" +
"                        \"text\": \"IPromise\"\n" +
"                    },\n" +
"                    \"type\": [\n" +
"                    ],\n" +
"                    \"types\": [\n" +
"                    ],\n" +
"                    \"typeArguments\": [\n" +
"                        {\n" +
"                            \"kind\": \"FirstTypeNode\",\n" +
"                            \"typeName\": {\n" +
"                                \"text\": \"T\"\n" +
"                            },\n" +
"                            \"type\": [\n" +
"                            ],\n" +
"                            \"types\": [\n" +
"                            ],\n" +
"                            \"typeArguments\": [\n" +
"                            ],\n" +
"                            \"parameters\": [\n" +
"                            ],\n" +
"                            \"elementType\": [\n" +
"                            ],\n" +
"                            \"members\": [\n" +
"                            ]\n" +
"                        }\n" +
"                    ],\n" +
"                    \"parameters\": [\n" +
"                    ],\n" +
"                    \"elementType\": [\n" +
"                    ],\n" +
"                    \"members\": [\n" +
"                    ]\n" +
"                },\n" +
"                {\n" +
"                    \"kind\": \"FirstTypeNode\",\n" +
"                    \"typeName\": {\n" +
"                        \"text\": \"T\"\n" +
"                    },\n" +
"                    \"type\": [\n" +
"                    ],\n" +
"                    \"types\": [\n" +
"                    ],\n" +
"                    \"typeArguments\": [\n" +
"                    ],\n" +
"                    \"parameters\": [\n" +
"                    ],\n" +
"                    \"elementType\": [\n" +
"                    ],\n" +
"                    \"members\": [\n" +
"                    ]\n" +
"                }\n" +
"            ],\n" +
"            \"typeArguments\": [\n" +
"            ],\n" +
"            \"parameters\": [\n" +
"            ],\n" +
"            \"elementType\": [\n" +
"            ],\n" +
"            \"members\": [\n" +
"            ]\n" +
"        }\n" +
"    ],\n" +
"    \"types\": [\n" +
"    ],\n" +
"    \"typeArguments\": [\n" +
"    ],\n" +
"    \"parameters\": [\n" +
"        {\n" +
"            \"name\": {\n" +
"                \"text\": \"response\"\n" +
"            },\n" +
"            \"type\": {\n" +
"                \"kind\": \"FirstTypeNode\",\n" +
"                \"typeName\": {\n" +
"                    \"text\": \"IHttpPromiseCallbackArg\"\n" +
"                },\n" +
"                \"type\": [\n" +
"                ],\n" +
"                \"types\": [\n" +
"                ],\n" +
"                \"typeArguments\": [\n" +
"                    {\n" +
"                        \"kind\": \"FirstTypeNode\",\n" +
"                        \"typeName\": {\n" +
"                            \"text\": \"T\"\n" +
"                        },\n" +
"                        \"type\": [\n" +
"                        ],\n" +
"                        \"types\": [\n" +
"                        ],\n" +
"                        \"typeArguments\": [\n" +
"                        ],\n" +
"                        \"parameters\": [\n" +
"                        ],\n" +
"                        \"elementType\": [\n" +
"                        ],\n" +
"                        \"members\": [\n" +
"                        ]\n" +
"                    }\n" +
"                ],\n" +
"                \"parameters\": [\n" +
"                ],\n" +
"                \"elementType\": [\n" +
"                ],\n" +
"                \"members\": [\n" +
"                ]\n" +
"            },\n" +
"            \"questionToken\": null,\n" +
"            \"dotDotDotToken\": null\n" +
"        }\n" +
"    ]\n" +
"}";
        Type astType = Models.parse(ctx, Type.class, new ByteArrayInputStream(type.getBytes()));
        assertEquals("Type variable T is there", "T", astType.getType().get(0).getTypes().get(0).getTypeArguments().get(0).getTypeName().getSimpleName());
        astType.anonimize();
        assertEquals("Type variable has been anonymized", "?", astType.getType().get(0).getTypes().get(0).getTypeArguments().get(0).getTypeName().getSimpleName());
    }
}
