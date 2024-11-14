using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Data.SqlClient;

public partial class adminAddUser : System.Web.UI.Page
{
    SqlConnection con = new SqlConnection(@"Data Source=.\SQLEXPRESS;AttachDbFilename=|Datadirectory|\recordPatient.mdf;Integrated Security=True;User Instance=True");
    SqlCommand cmd;

    protected void Page_Load(object sender, EventArgs e)
    {

    }
    protected void Button2_Click(object sender, EventArgs e)
    {
        cmd = new SqlCommand("select * from userTB where Username ='" + username.Text + "' or name ='"+name.Text+"' ", con);

        SqlDataAdapter da = new SqlDataAdapter(cmd);
        DataTable dt = new DataTable();
        da.Fill(dt);
        if (dt.Rows.Count > 0)
        {

            Response.Write("<script>alert('This Username  is already taken')</script>");
        }


        else
        {
            string s = FileUpload1.PostedFile.FileName;
            FileUpload1.PostedFile.SaveAs(Server.MapPath("~/upload/" + s));
            string a = "~/upload/" + s;
            string filename = System.IO.Path.GetFileName(FileUpload1.PostedFile.FileName);


            cmd = new SqlCommand("insert into userTB values('" + name.Text + "','" + age.Text + "','" + dob.Text + "','" + sp.Text + "','" + phone.Text + "','" + email.Text + "','" + address.Text + "','" + username.Text + "','" + password.Text + "','" + filename + "')", con);
            con.Open();
            cmd.ExecuteNonQuery();
            con.Close();


           // System.Diagnostics.Process.Start(@"H:\Project asp\PG\patient-Record-management-using-biometrics\LiveRecognition\bin\Debug\LiveRecognition_VS2010+", username.Text);

            Response.Write("<script>alert('User Added')</script>");
        }
    }
    protected void Button1_Click(object sender, EventArgs e)
    {
        name.Text = "";
        age.Text = "";
        dob.Text = "";
        sp.Text = "";
        phone.Text = "";
        email.Text = "";
        address.Text = "";
        username.Text = "";
        password.Text = "";
    }
}