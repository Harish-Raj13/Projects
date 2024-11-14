<%@ Page Title="" Language="C#" MasterPageFile="~/Admin.master" AutoEventWireup="true" CodeFile="adminAddSpecial.aspx.cs" Inherits="adminAddSpecial" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <table class="w-100">
        <tr>
            <td style="width: 302px; height: 24px">
                &nbsp;</td>
            <td class="text-center" style="width: 168px; height: 24px">
                &nbsp;</td>
            <td style="height: 24px; width: 153px">
                &nbsp;</td>
            <td style="height: 24px">
                &nbsp;</td>
        </tr>
        <tr>
            <td style="width: 302px; height: 24px">
                &nbsp;</td>
            <td class="text-center" style="width: 168px; height: 24px">
                &nbsp;</td>
            <td style="height: 24px; width: 153px">
                &nbsp;</td>
            <td style="height: 24px">
                &nbsp;</td>
        </tr>
        <tr>
            <td style="width: 302px; height: 24px">
                &nbsp;</td>
            <td class="text-center" style="width: 168px; height: 24px">
                &nbsp;</td>
            <td style="height: 24px; width: 153px">
                &nbsp;</td>
            <td style="height: 24px">
                &nbsp;</td>
        </tr>
        <tr>
            <td style="width: 302px; height: 24px">
                &nbsp;</td>
            <td class="text-center" style="width: 168px; height: 24px">
                <asp:Label ID="Label7" runat="server" Text="Choose Patient"></asp:Label>
            </td>
            <td style="height: 24px; width: 153px">
                &nbsp;</td>
            <td style="height: 24px">
                &nbsp;</td>
        </tr>
        <tr>
            <td style="width: 302px; height: 24px">
                &nbsp;</td>
            <td class="text-center" style="height: 24px" colspan="2">
                <asp:DropDownList ID="DropDownList1" runat="server" Width="400px">
                </asp:DropDownList>
            </td>
            <td style="height: 24px">
                &nbsp;</td>
        </tr>
        <tr>
            <td style="width: 302px; height: 24px">
            </td>
            <td class="text-center" style="width: 168px; height: 24px">
                <asp:Label ID="Label2" runat="server" Text="Respiratory rate"></asp:Label>
            </td>
            <td style="height: 24px; width: 153px">
                &nbsp;</td>
            <td style="height: 24px">
            </td>
        </tr>
        <tr>
            <td style="width: 302px; height: 26px">
                &nbsp;</td>
            <td class="text-center" style="height: 26px" colspan="2">
                <asp:TextBox ID="res" runat="server" Width="400px"></asp:TextBox>
            </td>
            <td style="height: 26px">
                &nbsp;</td>
        </tr>
        <tr>
            <td style="width: 302px; height: 26px">
            </td>
            <td class="text-center" style="width: 168px; height: 26px">
                <asp:Label ID="Label3" runat="server" Text="Sleeping patterns"></asp:Label>
            </td>
            <td style="height: 26px; width: 153px">
            </td>
            <td style="height: 26px">
            </td>
        </tr>
        <tr>
            <td style="width: 302px; height: 26px">
                &nbsp;</td>
            <td class="text-center" style="height: 26px" colspan="2">
                <asp:TextBox ID="sleep"  Width="400px" runat="server"></asp:TextBox>
            </td>
            <td style="height: 26px">
                &nbsp;</td>
        </tr>
        <tr>
            <td style="width: 302px; height: 26px">
                &nbsp;</td>
            <td class="text-center" style="width: 168px; height: 26px">
                <asp:Label ID="Label4" runat="server" Text="Blood pressure"></asp:Label>
            </td>
            <td style="height: 26px; width: 153px">
                &nbsp;</td>
            <td style="height: 26px">
                &nbsp;</td>
        </tr>
        <tr>
            <td style="width: 302px; height: 26px">
                &nbsp;</td>
            <td class="text-center" style="height: 26px" colspan="2">
                <asp:TextBox ID="bp" Width="400px" runat="server"></asp:TextBox>
            </td>
            <td style="height: 26px">
                &nbsp;</td>
        </tr>
        <tr>
            <td style="width: 302px; height: 26px">
                &nbsp;</td>
            <td class="text-center" style="width: 168px; height: 26px">
                <asp:Label ID="Label5" runat="server" Text="Diabetic Level"></asp:Label>
            </td>
            <td style="height: 26px; width: 153px">
                &nbsp;</td>
            <td style="height: 26px">
                &nbsp;</td>
        </tr>
        <tr>
            <td style="width: 302px; height: 26px">
                &nbsp;</td>
            <td class="text-center" style="height: 26px" colspan="2">
                <asp:TextBox ID="sp" Width="400px" runat="server"></asp:TextBox>
            </td>
            <td style="height: 26px">
                &nbsp;</td>
        </tr>
        <tr>
            <td style="width: 302px; height: 26px">
                &nbsp;</td>
            <td class="text-center" style="width: 168px; height: 26px">
                <asp:Label ID="Label6" runat="server" Text="Heart rate"></asp:Label>
            </td>
            <td style="height: 26px; width: 153px">
                &nbsp;</td>
            <td style="height: 26px">
                &nbsp;</td>
        </tr>
        <tr>
            <td style="width: 302px; height: 26px">
                &nbsp;</td>
            <td class="text-center" style="height: 26px" colspan="2">
                <asp:TextBox ID="heart" Width="400px" runat="server"></asp:TextBox>
            </td>
            <td style="height: 26px">
                &nbsp;</td>
        </tr>
        <tr>
            <td>
                &nbsp;</td>
            <td>
                &nbsp;</td>
            <td>
                &nbsp;</td>
            <td>
                &nbsp;</td>
        </tr>
        <tr>
            <td>
                &nbsp;</td>
            <td>
                <asp:Button ID="Button2" runat="server" onclick="Button2_Click" 
                    Text="Clear" />
            </td>
            <td>
                <asp:Button ID="Button1" runat="server" onclick="Button1_Click" 
                    Text="Add" Width="62px" />
            </td>
            <td>
                &nbsp;</td>
        </tr>
        <tr>
            <td>
                &nbsp;</td>
            <td>
                &nbsp;</td>
            <td>
                &nbsp;</td>
            <td>
                &nbsp;</td>
        </tr>
        <tr>
            <td>
                &nbsp;</td>
            <td>
                &nbsp;</td>
            <td>
                &nbsp;</td>
            <td>
                &nbsp;</td>
        </tr>
        <tr>
            <td>
                &nbsp;</td>
            <td>
                &nbsp;</td>
            <td>
                &nbsp;</td>
            <td>
                &nbsp;</td>
        </tr>
    </table>
</asp:Content>

