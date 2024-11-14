
<%@ Page Title="" Language="C#" MasterPageFile="~/Admin.master" AutoEventWireup="true" CodeFile="adminAddFile.aspx.cs" Inherits="adminAddFile" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <table class="w-100">
        <tr>
            <td style="width: 310px">
                &nbsp;</td>
            <td style="width: 146px">
                &nbsp;</td>
            <td>
                &nbsp;</td>
            <td>
                &nbsp;</td>
        </tr>
        <tr>
            <td style="width: 310px">
                &nbsp;</td>
            <td style="width: 146px">
                &nbsp;</td>
            <td>
                &nbsp;</td>
            <td>
                &nbsp;</td>
        </tr>
        <tr>
            <td style="width: 310px; height: 26px">
            </td>
            <td style="width: 146px; height: 26px">
                <asp:Label ID="Label1" runat="server" Text="Add Files :"></asp:Label>
            </td>
            <td style="height: 26px">
            </td>
            <td style="height: 26px">
            </td>
        </tr>
        <tr>
            <td style="width: 310px">
                &nbsp;</td>
            <td style="width: 146px">
                &nbsp;</td>
            <td>
                &nbsp;</td>
            <td>
                &nbsp;</td>
        </tr>
        <tr>
            <td style="width: 310px">
                &nbsp;</td>
            <td style="width: 146px">
                <asp:Label ID="Label3" runat="server" Text="Choose patient"></asp:Label>
            </td>
            <td>
                &nbsp;</td>
            <td>
                &nbsp;</td>
        </tr>
        <tr>
            <td style="width: 310px; height: 26px;">
                &nbsp;</td>
            <td style="height: 26px;" colspan="2">
                <asp:DropDownList ID="DropDownList1" runat="server" Width="400px">
                </asp:DropDownList>
            </td>
            <td style="height: 26px">
                &nbsp;</td>
        </tr>
        <tr>
            <td style="width: 310px; height: 26px;">
                </td>
            <td style="width: 146px; height: 26px;">
                <asp:Label ID="Label4" runat="server" Text="File Name"></asp:Label>
            </td>
            <td style="height: 26px">
                &nbsp;</td>
            <td style="height: 26px">
                </td>
        </tr>
        <tr>
            <td style="width: 310px">
                &nbsp;</td>
            <td colspan="2">
                <asp:TextBox ID="TextBox1" runat="server" Width="400px"></asp:TextBox>
            </td>
            <td>
                &nbsp;</td>
        </tr>
        <tr>
            <td style="width: 310px">
                &nbsp;</td>
            <td style="width: 146px">
                <asp:Label ID="Label2" runat="server" Text="Upload File "></asp:Label>
            </td>
            <td>
                &nbsp;</td>
            <td>
                &nbsp;</td>
        </tr>
        <tr>
            <td style="width: 310px">
                &nbsp;</td>
            <td colspan="2">
                <asp:FileUpload ID="FileUpload1" runat="server" Width="400px" />
            </td>
            <td>
                &nbsp;</td>
        </tr>
        <tr>
            <td style="width: 310px">
                &nbsp;</td>
            <td style="width: 146px">
                &nbsp;</td>
            <td>
                &nbsp;</td>
            <td>
                &nbsp;</td>
        </tr>
        <tr>
            <td style="width: 310px">
                &nbsp;</td>
            <td style="width: 146px">
                <asp:Button ID="Button2" runat="server" onclick="Button2_Click" Text="Clear" />
            </td>
            <td>
                <asp:Button ID="Button1" runat="server" onclick="Button1_Click" 
                    Text="Upload " />
            </td>
            <td>
                &nbsp;</td>
        </tr>
        <tr>
            <td style="width: 310px">
                &nbsp;</td>
            <td style="width: 146px">
                &nbsp;</td>
            <td>
                &nbsp;</td>
            <td>
                &nbsp;</td>
        </tr>
    </table>
</asp:Content>

