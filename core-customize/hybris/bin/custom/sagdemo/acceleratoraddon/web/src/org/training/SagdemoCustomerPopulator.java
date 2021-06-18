public class OccaddonCustomerPopulator implements Populator<CustomerModel, CustomerData> {
    private Converter<AddressModel, AddressData> addressConverter;
    @Override
    public void populate(final CustomerModel source, final CustomerData target) throws ConversionException
    {
        Assert.notNull(source, "Parameter source cannot be null.");
        Assert.notNull(target, "Parameter target cannot be null.");
        target.setNickname(source.getNickname());
        if (source.getWorkOfficeAddress() != null)
        {
            target.setWorkOfficeAddress(getAddressConverter().convert(source.getWorkOfficeAddress()));
        }
    }
    protected Converter<AddressModel, AddressData> getAddressConverter()
    {
        return addressConverter;
    }
    @Required
    public void setAddressConverter(final Converter<AddressModel, AddressData> addressConverter)
    {
        this.addressConverter = addressConverter;
    }
}