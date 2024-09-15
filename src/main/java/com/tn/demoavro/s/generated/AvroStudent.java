/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.tn.demoavro.s.generated;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class AvroStudent extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 3611878768727310117L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"AvroStudent\",\"namespace\":\"com.tn.demoavro.s.generated\",\"fields\":[{\"name\":\"studentName\",\"type\":\"string\"},{\"name\":\"studentId\",\"type\":\"string\"},{\"name\":\"age\",\"type\":\"int\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<AvroStudent> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<AvroStudent> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<AvroStudent> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<AvroStudent> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<AvroStudent> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this AvroStudent to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a AvroStudent from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a AvroStudent instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static AvroStudent fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.CharSequence studentName;
  private java.lang.CharSequence studentId;
  private int age;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public AvroStudent() {}

  /**
   * All-args constructor.
   * @param studentName The new value for studentName
   * @param studentId The new value for studentId
   * @param age The new value for age
   */
  public AvroStudent(java.lang.CharSequence studentName, java.lang.CharSequence studentId, java.lang.Integer age) {
    this.studentName = studentName;
    this.studentId = studentId;
    this.age = age;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return studentName;
    case 1: return studentId;
    case 2: return age;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: studentName = (java.lang.CharSequence)value$; break;
    case 1: studentId = (java.lang.CharSequence)value$; break;
    case 2: age = (java.lang.Integer)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'studentName' field.
   * @return The value of the 'studentName' field.
   */
  public java.lang.CharSequence getStudentName() {
    return studentName;
  }


  /**
   * Sets the value of the 'studentName' field.
   * @param value the value to set.
   */
  public void setStudentName(java.lang.CharSequence value) {
    this.studentName = value;
  }

  /**
   * Gets the value of the 'studentId' field.
   * @return The value of the 'studentId' field.
   */
  public java.lang.CharSequence getStudentId() {
    return studentId;
  }


  /**
   * Sets the value of the 'studentId' field.
   * @param value the value to set.
   */
  public void setStudentId(java.lang.CharSequence value) {
    this.studentId = value;
  }

  /**
   * Gets the value of the 'age' field.
   * @return The value of the 'age' field.
   */
  public int getAge() {
    return age;
  }


  /**
   * Sets the value of the 'age' field.
   * @param value the value to set.
   */
  public void setAge(int value) {
    this.age = value;
  }

  /**
   * Creates a new AvroStudent RecordBuilder.
   * @return A new AvroStudent RecordBuilder
   */
  public static com.tn.demoavro.s.generated.AvroStudent.Builder newBuilder() {
    return new com.tn.demoavro.s.generated.AvroStudent.Builder();
  }

  /**
   * Creates a new AvroStudent RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new AvroStudent RecordBuilder
   */
  public static com.tn.demoavro.s.generated.AvroStudent.Builder newBuilder(com.tn.demoavro.s.generated.AvroStudent.Builder other) {
    if (other == null) {
      return new com.tn.demoavro.s.generated.AvroStudent.Builder();
    } else {
      return new com.tn.demoavro.s.generated.AvroStudent.Builder(other);
    }
  }

  /**
   * Creates a new AvroStudent RecordBuilder by copying an existing AvroStudent instance.
   * @param other The existing instance to copy.
   * @return A new AvroStudent RecordBuilder
   */
  public static com.tn.demoavro.s.generated.AvroStudent.Builder newBuilder(com.tn.demoavro.s.generated.AvroStudent other) {
    if (other == null) {
      return new com.tn.demoavro.s.generated.AvroStudent.Builder();
    } else {
      return new com.tn.demoavro.s.generated.AvroStudent.Builder(other);
    }
  }

  /**
   * RecordBuilder for AvroStudent instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<AvroStudent>
    implements org.apache.avro.data.RecordBuilder<AvroStudent> {

    private java.lang.CharSequence studentName;
    private java.lang.CharSequence studentId;
    private int age;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.tn.demoavro.s.generated.AvroStudent.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.studentName)) {
        this.studentName = data().deepCopy(fields()[0].schema(), other.studentName);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.studentId)) {
        this.studentId = data().deepCopy(fields()[1].schema(), other.studentId);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.age)) {
        this.age = data().deepCopy(fields()[2].schema(), other.age);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
    }

    /**
     * Creates a Builder by copying an existing AvroStudent instance
     * @param other The existing instance to copy.
     */
    private Builder(com.tn.demoavro.s.generated.AvroStudent other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.studentName)) {
        this.studentName = data().deepCopy(fields()[0].schema(), other.studentName);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.studentId)) {
        this.studentId = data().deepCopy(fields()[1].schema(), other.studentId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.age)) {
        this.age = data().deepCopy(fields()[2].schema(), other.age);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'studentName' field.
      * @return The value.
      */
    public java.lang.CharSequence getStudentName() {
      return studentName;
    }


    /**
      * Sets the value of the 'studentName' field.
      * @param value The value of 'studentName'.
      * @return This builder.
      */
    public com.tn.demoavro.s.generated.AvroStudent.Builder setStudentName(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.studentName = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'studentName' field has been set.
      * @return True if the 'studentName' field has been set, false otherwise.
      */
    public boolean hasStudentName() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'studentName' field.
      * @return This builder.
      */
    public com.tn.demoavro.s.generated.AvroStudent.Builder clearStudentName() {
      studentName = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'studentId' field.
      * @return The value.
      */
    public java.lang.CharSequence getStudentId() {
      return studentId;
    }


    /**
      * Sets the value of the 'studentId' field.
      * @param value The value of 'studentId'.
      * @return This builder.
      */
    public com.tn.demoavro.s.generated.AvroStudent.Builder setStudentId(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.studentId = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'studentId' field has been set.
      * @return True if the 'studentId' field has been set, false otherwise.
      */
    public boolean hasStudentId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'studentId' field.
      * @return This builder.
      */
    public com.tn.demoavro.s.generated.AvroStudent.Builder clearStudentId() {
      studentId = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'age' field.
      * @return The value.
      */
    public int getAge() {
      return age;
    }


    /**
      * Sets the value of the 'age' field.
      * @param value The value of 'age'.
      * @return This builder.
      */
    public com.tn.demoavro.s.generated.AvroStudent.Builder setAge(int value) {
      validate(fields()[2], value);
      this.age = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'age' field has been set.
      * @return True if the 'age' field has been set, false otherwise.
      */
    public boolean hasAge() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'age' field.
      * @return This builder.
      */
    public com.tn.demoavro.s.generated.AvroStudent.Builder clearAge() {
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public AvroStudent build() {
      try {
        AvroStudent record = new AvroStudent();
        record.studentName = fieldSetFlags()[0] ? this.studentName : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.studentId = fieldSetFlags()[1] ? this.studentId : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.age = fieldSetFlags()[2] ? this.age : (java.lang.Integer) defaultValue(fields()[2]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<AvroStudent>
    WRITER$ = (org.apache.avro.io.DatumWriter<AvroStudent>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<AvroStudent>
    READER$ = (org.apache.avro.io.DatumReader<AvroStudent>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.studentName);

    out.writeString(this.studentId);

    out.writeInt(this.age);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.studentName = in.readString(this.studentName instanceof Utf8 ? (Utf8)this.studentName : null);

      this.studentId = in.readString(this.studentId instanceof Utf8 ? (Utf8)this.studentId : null);

      this.age = in.readInt();

    } else {
      for (int i = 0; i < 3; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.studentName = in.readString(this.studentName instanceof Utf8 ? (Utf8)this.studentName : null);
          break;

        case 1:
          this.studentId = in.readString(this.studentId instanceof Utf8 ? (Utf8)this.studentId : null);
          break;

        case 2:
          this.age = in.readInt();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










