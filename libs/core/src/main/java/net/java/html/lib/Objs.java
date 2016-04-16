package net.java.html.lib;

/*
 * #%L
 * ES6 Core Library - a library from the DukeScript project.
 * Visit http://dukescript.com for support and commercial license.
 * %%
 * Copyright (C) 2015 - 2016 Dukehoff GmbH
 * %%
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * #L%
 */
public class Objs extends java.lang.Object {
    private final java.lang.Object js;
    private static final Constructor<Objs> $AS = new Constructor<Objs>(Objs.class) {
        @Override
        protected Objs create(Object any) {
            return $as(any);
        }
    };

    /** Constructor for auto-generated subclasses. From client code
     * use {@link #$as(java.lang.Object)} or {@link #$as(java.lang.Class, java.lang.Object)}.
     *
     * @param constructor constructor {@link Constructor#Constructor(java.lang.Class) associated with this type}
     * @param js any raw object to be wrapped by this instance
     */
    protected Objs(Constructor<?> constructor, java.lang.Object js) {
        assert constructor.clazz.isInstance(this);
        this.js = $js(js);
    }

    /** Casts given object to this class.
     *
     * @param obj any object
     * @return a view of the provided <code>obj</code> object
     */
    public static Objs $as(java.lang.Object obj) {
        return new Objs($AS, obj);
    }

    /** Casts given object to requested class.
     *
     * @param <T> the type of requested object
     * @param clazz identification of the type
     * @param obj object to be converted
     * @return a view of the provided <code>obj</code> object
     * @throws ClassCastException if the <code>obj</code> cannot be cast to
     *   the requested class
     */
    public static <T> T $as(java.lang.Class<T> clazz, java.lang.Object obj) {
        if (clazz.isInstance(obj)) {
            return clazz.cast(obj);
        }
        obj = $js(obj);
        Constructor<?> c = Constructor.find(clazz);
        if (c != null) {
            obj = c.create(obj);
        }
        return clazz.cast(obj);
    }
    static java.lang.Object $as(String clazz, java.lang.Object obj) {
        try {
            return $as(Class.forName(clazz), obj);
        } catch (ClassNotFoundException ex) {
            obj = $js(obj);
            Constructor<?> c = Constructor.find(clazz);
            if (c != null) {
                obj = c.create(obj);
            }
            return obj;
        }
    }

    /**
     * Unwraps the object into plain JavaScript one.
     *
     * @param obj an object to unwrap - either subclass of <code>Objs</code> or
     * plain JavaScript object
     * @return the raw JavaScript object hidden behind the <code>obj</code> one
     */
    public static java.lang.Object $js(java.lang.Object obj) {
        if (obj instanceof Objs) {
            Objs objs = (Objs) obj;
            return objs.js;
        }
        return net.java.html.lib.Function.specialJs(obj);
    }

    /** "Casts" this object to some other one. Creates
     * a wrapper for the JavaScript object represented by this
     * instance, so one can view it as different object.
     *
     * @param <T> type one requests
     * @param clazz requested class
     * @return instance of the requested type
     * @throws ClassCastException if cast cannot be done
     */
    public <T extends Objs> T $cast(Class<T> clazz) {
        return $as(clazz, this);
    }

  public java.lang.Object $get(java.lang.String n) {
    return getRaw($js(this), /* AnyKeyword*/$js(n));
  }
  @net.java.html.js.JavaScriptBody(args={"self", "n"}, body=
    "return self[n];\n"
  )
  static native java.lang.Object getRaw(java.lang.Object self, java.lang.Object n);
  public void $set(java.lang.String k,java.lang.Object n) {
    setRaw($js(this), $js(k), $js(n));
  }
  @net.java.html.js.JavaScriptBody(args={"self", "k", "n"}, body=
    "return self[k] = n;\n"
  )
  static native Object setRaw(java.lang.Object self, java.lang.Object k, java.lang.Object n);
  public void $delete(java.lang.String k) {
    deleteRaw($js(this), $js(k));
  }
  @net.java.html.js.JavaScriptBody(args={"self", "k"}, body=
    "delete self[k];\n"
  )
  private static native void deleteRaw(java.lang.Object self, java.lang.Object k);
  /**
  * Determines whether an object has a property with the specified name.
  * @param v A property name.
  */
  public java.lang.Boolean hasOwnProperty(java.lang.String v) {
    return CoreTypes.hasOwnProperty$487($js(this), v);
  }
  /**
  * Determines whether an object exists in another object's prototype chain.
  * @param v Another object whose prototype chain is to be checked.
  */
  public java.lang.Boolean isPrototypeOf(java.lang.Object v) {
    return CoreTypes.isPrototypeOf$488($js(this), /* FirstTypeNode*/$js(v));
  }
  /**
  * Determines whether a specified property is enumerable.
  * @param v A property name.
  */
  public java.lang.Boolean propertyIsEnumerable(java.lang.String v) {
    return CoreTypes.propertyIsEnumerable$489($js(this), v);
  }
  /** Returns a date converted to a string using the current locale. */
  public java.lang.String toLocaleString() {
    return CoreTypes.toLocaleString$490($js(this));
  }
  /** Returns a string representation of an object. */
  public java.lang.String toString() {
      final Object objs = $js(this);
      try {
        return CoreTypes.toString$491(objs);
      } catch (IllegalStateException ex) {
        return getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(objs));
      }
  }
  /** Returns the primitive value of the specified object. */
  public java.lang.Object valueOf() {
    return (java.lang.Object)CoreTypes.valueOf$492($js(this));
  }
  // constructor ObjectConstructor
  /** A reference to the prototype for a class of objects. */
  public static java.lang.Object prototype;
  /**
  * Returns the prototype of an object.
  * @param o The object that references the prototype.
  */
  public static java.lang.Object getPrototypeOf(java.lang.Object o) {
    return CoreTypes.getPrototypeOf$493(/* AnyKeyword*/$js(o));
  }
  /**
  * Gets the own property descriptor of the specified object.
  * An own property descriptor is one that is defined directly on the object and is not inherited from the object's prototype.
  * @param o Object that contains the property.
  * @param p Name of the property.
  */
  public static PropertyDescriptor getOwnPropertyDescriptor(java.lang.Object o, java.lang.String p) {
    return PropertyDescriptor.$as(CoreTypes.getOwnPropertyDescriptor$494(/* AnyKeyword*/$js(o), p));
  }
  /**
  * Returns the names of the own properties of an object. The own properties of an object are those that are defined directly
  * on that object, and are not inherited from the object's prototype. The properties of an object include both fields (objects) and functions.
  * @param o Object that contains the own properties.
  */
  public static java.lang.String[] getOwnPropertyNames(java.lang.Object o) {
    return CoreTypes.getOwnPropertyNames$495(/* AnyKeyword*/$js(o));
  }
  /**
  * Creates an object that has the specified prototype, and that optionally contains specified properties.
  * @param o Object to use as a prototype. May be null
  * @param properties JavaScript object that contains one or more property descriptors.
  */
  public static java.lang.Object create(java.lang.Object o, PropertyDescriptorMap properties) {
    return CoreTypes.create$496(/* AnyKeyword*/$js(o), /* FirstTypeNode*/$js(properties));
  }
  /**
  * Creates an object that has the specified prototype, and that optionally contains specified properties.
  * @param o Object to use as a prototype. May be null
  * @param properties JavaScript object that contains one or more property descriptors.
  */
  public static java.lang.Object create(java.lang.Object o) {
    return CoreTypes.create$497(/* AnyKeyword*/$js(o));
  }
  /**
  * Adds a property to an object, or modifies attributes of an existing property.
  * @param o Object on which to add or modify the property. This can be a native JavaScript object (that is, a user-defined object or a built in object) or a DOM object.
  * @param p The property name.
  * @param attributes Descriptor for the property. It can be for a data property or an accessor property.
  */
  public static java.lang.Object defineProperty(java.lang.Object o, java.lang.String p, PropertyDescriptor attributes) {
    return CoreTypes.defineProperty$498(/* AnyKeyword*/$js(o), p, /* FirstTypeNode*/$js(attributes));
  }
  /**
  * Adds one or more properties to an object, and/or modifies attributes of existing properties.
  * @param o Object on which to add or modify the properties. This can be a native JavaScript object or a DOM object.
  * @param properties JavaScript object that contains one or more descriptor objects. Each descriptor object describes a data property or an accessor property.
  */
  public static java.lang.Object defineProperties(java.lang.Object o, PropertyDescriptorMap properties) {
    return CoreTypes.defineProperties$499(/* AnyKeyword*/$js(o), /* FirstTypeNode*/$js(properties));
  }
  /**
  * Prevents the modification of attributes of existing properties, and prevents the addition of new properties.
  * @param o Object on which to lock the attributes.
  */
  public static <T> T seal(T o) {
    return (T)CoreTypes.seal$500(/* FirstTypeNode*/$js(o));
  }
  /**
  * Prevents the modification of existing property attributes and values, and prevents the addition of new properties.
  * @param o Object on which to lock the attributes.
  */
  public static <T> T freeze(T o) {
    return (T)CoreTypes.freeze$501(/* FirstTypeNode*/$js(o));
  }
  /**
  * Prevents the addition of new properties to an object.
  * @param o Object to make non-extensible.
  */
  public static <T> T preventExtensions(T o) {
    return (T)CoreTypes.preventExtensions$502(/* FirstTypeNode*/$js(o));
  }
  /**
  * Returns true if existing property attributes cannot be modified in an object and new properties cannot be added to the object.
  * @param o Object to test.
  */
  public static java.lang.Boolean isSealed(java.lang.Object o) {
    return CoreTypes.isSealed$503(/* AnyKeyword*/$js(o));
  }
  /**
  * Returns true if existing property attributes and values cannot be modified in an object, and new properties cannot be added to the object.
  * @param o Object to test.
  */
  public static java.lang.Boolean isFrozen(java.lang.Object o) {
    return CoreTypes.isFrozen$504(/* AnyKeyword*/$js(o));
  }
  /**
  * Returns a value that indicates whether new properties can be added to an object.
  * @param o Object to test.
  */
  public static java.lang.Boolean isExtensible(java.lang.Object o) {
    return CoreTypes.isExtensible$505(/* AnyKeyword*/$js(o));
  }
  /**
  * Returns the names of the enumerable properties and methods of an object.
  * @param o Object that contains the properties and methods. This can be an object that you created or an existing Document Object Model (DOM) object.
  */
  public static Array<String> keys(java.lang.Object o) {
    return (Array<String>)Array.$as(CoreTypes.keys$506(/* AnyKeyword*/$js(o)));
  }
  public Objs(java.lang.Object value) {
    this($AS, CoreTypes.new$507(/* AnyKeyword*/$js(value)));
  }
  public Objs() {
    this($AS, CoreTypes.new$508());
  }
  public static java.lang.Object newObject() {
    return CoreTypes.newObject$509();
  }
  public static java.lang.Object newObject(java.lang.Object value) {
    return CoreTypes.newObject$510(/* AnyKeyword*/$js(value));
  }

  /** Factory for one subclass of {@link Objs} wrapper. It is used
   * from {@link Objs#$as(java.lang.Class, java.lang.Object)} method.
   *
   * @param <T> type this constructor produces
   */
  protected static abstract class Constructor<T extends Objs> {
      private static Constructor<?> head;
      final Class<T> clazz;
      final Constructor<?> next;

      /** Registers the instance to the system.
       *
       * @param clazz subclass of {@link Objs} this constructor can handle
       */
      protected Constructor(Class<T> clazz) {
          this.clazz = clazz;
          this.next = head;
          synchronized (Constructor.class) {
              head = this;
          }
      }

      /** Wraps any object into instance of associated {@link Objs} type.
       *
       * @param any object to be wrapped
       * @return new instance of a wrapper
       */
      protected abstract T create(Object any);

      static Constructor<?> find(Class<?> clazz) {
          if (Union.class.isAssignableFrom(clazz)) {
              clazz = Union.class;
          } else if (Function.A5.class.isAssignableFrom(clazz)) {
              clazz = Function.class;
          }
          for (int i = 0; i <= 2; i++) {
              Constructor<?> c = head;
              for (;;) {
                  if (c == null) {
                      break;
                  }
                  if (c.clazz == clazz) {
                      return c;
                  }
                  c = c.next;
              }
              initializeClass(clazz);
          }
          return null;
      }

      static Constructor<?> find(String clazz) {
          if (clazz.startsWith(Union.class.getName())) {
              return find(Union.class);
          } else if (clazz.startsWith(Function.class.getName())) {
              return find(Function.class);
          }
          Constructor<?> c = head;
          for (;;) {
              if (c == null) {
                  break;
              }
              if (c.clazz.getName().equals(clazz)) {
                  return c;
              }
              c = c.next;
          }
          return null;
      }

        private static void initializeClass(Class<?> c) {
            try {
                // most simple way to run class initializations
                c.newInstance();
            } catch (Throwable ex) {
                try {
                    Class.forName(c.getName(), true, c.getClassLoader());
                } catch (ClassNotFoundException ex1) {
                    // We can't do more
                }
            }
        }
    }

    /** Represents a property of an {@link Objs} object.
     *
     * @param <T> the type of the property
     */
    public static final class Property<T> {
        private final Objs js;
        private final Class<T> type;
        private final Constructor<?> constructor;
        private final String property;

        private Property(Objs objs, Class<T> type, java.lang.String property) {
            this.js = objs;
            this.type = type;
            this.constructor = Constructor.find(type);
            this.property = property;
        }

        /** Creates new property for the object.
         *
         * @param <T> type of the property
         * @param obj the object the property belongs to
         * @param propertyType type of the property
         * @param property name of the property
         * @return property instances {@link #get() to use} later
         */
        public static <T> Property<T> create(Objs obj, Class<? extends Object> propertyType, java.lang.String property) {
            return new Property(obj, propertyType, property);
        }

        /** Get value of the property.
         *
         * @return the value
         */
        public T get() {
            Object raw = getRaw(Objs.$js(js), property);
            if (raw != null && constructor != null) {
                raw = constructor.create(raw);
            }
            return type.cast(raw);
        }

        /** Sets value of the property.
         *
         * @param value the value to set
         */
        public void set(T value) {
            Objs.setRaw(Objs.$js(js), property, Objs.$js(value));
        }
    }
}
